package com.nicomahnic.heladerakt.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.nicomahnic.heladerakt.R
import com.nicomahnic.heladerakt.ui.adapters.combos.CombosAdapter
import com.nicomahnic.heladerakt.ui.viewmodels.HomeVM
import com.nicomahnic.heladerakt.ui.adapters.opciones.IceCreamOptionsAdapter
import com.nicomahnic.heladerakt.databinding.FragmentHomeBinding
import com.nicomahnic.heladerakt.domain.models.IceCreamOption
import com.nicomahnic.heladerakt.domain.models.Combo
import com.nicomahnic.heladerakt.ui.dialog.SaveOrderDialog
import com.nicomahnic.heladerakt.ui.dialog.SelectTasteDialog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val combosList = mutableListOf<Combo>()
    private val iceCreamOptionList = mutableListOf<IceCreamOption>()

    private val homeVM: HomeVM by viewModels()
    private lateinit var binding : FragmentHomeBinding
    private lateinit var adapterIceCreamOptions: IceCreamOptionsAdapter
    private lateinit var adapterCombos: CombosAdapter
    private lateinit var v: View

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        v = view
        binding = FragmentHomeBinding.bind(view)

        initRecyclerView()

        binding.floatingSaveButton.setOnClickListener(onFloatingSaveClicked)
    }

    private fun initRecyclerView(){
        val rvIceCreamOptions = binding.rvIceCreamOptions
        rvIceCreamOptions.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL, false)
        adapterIceCreamOptions  = IceCreamOptionsAdapter(iceCreamOptionList, btnListener)
        rvIceCreamOptions.adapter = adapterIceCreamOptions

        CoroutineScope(Dispatchers.Main).launch{
            homeVM.getAllIceCreamOptions().collect { iceCreamOption ->
                iceCreamOption.forEach {
                    Log.d("NM", "delivery => ${it} ")
                    iceCreamOptionList.add(0, it)
                    adapterIceCreamOptions.notifyItemChanged(0)
                }
            }
        }

        val rvCombos = binding.rvCombos
        rvCombos.layoutManager = LinearLayoutManager(requireContext())
        adapterCombos  = CombosAdapter(combosList)
        rvCombos.adapter = adapterCombos
    }

    private val btnListener = object : IceCreamOptionsAdapter.BtnListener {
        override fun onBtnClick(iceCreamOption: IceCreamOption) {
            selectTasteDialog(iceCreamOption)
        }
    }

    private val onFloatingSaveClicked = object : View.OnClickListener{
        override fun onClick(p0: View?) { saveOrderDialog() }
    }

    private fun saveOrderDialog(){
        val dialog = SaveOrderDialog(combosList, homeVM, dismissSaveOrderDialog)
        val fm: FragmentManager = requireActivity().supportFragmentManager
        dialog.show(fm,"saveOrderDialog")
    }

    private fun selectTasteDialog(iceCreamOption: IceCreamOption){
        val combo = Combo(iceCreamOption.name)
        val dialog = SelectTasteDialog(homeVM, combo, dismissSelectTasteDialog)
        val fm: FragmentManager = requireActivity().supportFragmentManager
        dialog.show(fm,"selectTasteDialog")

    }

    private val dismissSelectTasteDialog = object : SelectTasteDialog.SelectTasteDialog {
        override fun dismiss(combo: Combo) {
            Log.d("NM", "COMBO -> $combo")
            combosList.add(0,combo)
            adapterCombos.notifyItemInserted(0)
            Log.d("NM", "COMBO LIST -> $combosList")
        }
    }

    private val dismissSaveOrderDialog = object : SaveOrderDialog.SaveOrderDialog {
        override fun dismiss() {
            val action = HomeFragmentDirections.actionHomeFragmentToOrdersFragment()
            v.findNavController().navigate(action)
        }
    }

}