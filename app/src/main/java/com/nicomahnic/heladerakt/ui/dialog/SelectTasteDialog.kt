package com.nicomahnic.heladerakt.ui.dialog

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputLayout
import com.nicomahnic.heladerakt.R
import com.nicomahnic.heladerakt.databinding.SaveComboDialogBinding
import com.nicomahnic.heladerakt.ui.viewmodels.HomeVM
import com.nicomahnic.heladerakt.ui.adapters.tastes.TastesAdapter
import com.nicomahnic.heladerakt.domain.models.Combo
import com.nicomahnic.heladerakt.domain.models.Taste
import com.nicomahnic.heladerakt.domain.models.TasteOption
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking

class SelectTasteDialog (
    private val homeVM: HomeVM,
    private val combo: Combo,
    private val selectTasteDialog: SelectTasteDialog
): DialogFragment() {

    interface SelectTasteDialog{
        fun dismiss(combo: Combo)
    }

    lateinit var binding: SaveComboDialogBinding
    lateinit var adapter: TastesAdapter
    private var allTastes = mutableListOf<TasteOption>()
    private var tastesTemp = mutableListOf<Taste>()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = SaveComboDialogBinding.inflate(LayoutInflater.from(requireContext()))

        binding.rvUsersDialog.layoutManager = LinearLayoutManager(requireContext())
        adapter  = TastesAdapter(allTastes, onItemSelected)
        binding.rvUsersDialog.adapter = adapter

        runBlocking {
            homeVM.getAllTastesOptions().collect { tastes ->
                tastes.forEach{
                    allTastes.add(0, it)
                    adapter.notifyItemChanged(0)
                }
            }
        }

        return MaterialAlertDialogBuilder(requireContext())
            .setTitle("Seleccione los gustos de helado")
            .setPositiveButton("Aceptar") { dialog, _ ->
                val d = dialog as Dialog
                val comment = d.findViewById<TextInputLayout>(R.id.tvOrderComment)
                comment.editText?.let { comment ->
                    Log.d("NM", "DISMISS list => ${tastesTemp}")
                    combo.tasteList = tastesTemp
                    combo.comment = comment.text.toString().trim()
                    dialog.dismiss()
                    selectTasteDialog.dismiss(combo)
                }
            }
            .setView(binding.root)
            .create()
    }

    private val onItemSelected = object :  TastesAdapter.ItemListener {
        override fun onBtnClick(tasteOption: TasteOption) {
            Log.d("NM", "DIALOG taste => ${tasteOption}")
            val taste = Taste(tasteOption.name, tasteOption.id)
            if(!tastesTemp.remove(taste)){
                tastesTemp.add(taste)
            }
            Log.d("NM", "DIALOG list => ${tastesTemp}")
        }
    }

}