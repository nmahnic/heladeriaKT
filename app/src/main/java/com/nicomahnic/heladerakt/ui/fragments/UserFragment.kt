package com.nicomahnic.heladerakt.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.nicomahnic.heladerakt.R
import com.nicomahnic.heladerakt.ui.viewmodels.UserVM
import com.nicomahnic.heladerakt.databinding.FragmentUserBinding
import com.nicomahnic.heladerakt.domain.models.User
import com.nicomahnic.heladerakt.ui.adapters.users.UsersAdapter
import com.nicomahnic.heladerakt.ui.dialog.AddUserDialog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class UserFragment : Fragment(R.layout.fragment_user) {

    private var usersTemp = mutableListOf<User>()
    private val userVM: UserVM by viewModels()
    private lateinit var binding : FragmentUserBinding
    private lateinit var adapter: UsersAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentUserBinding.bind(view)

        initRecyclerView()

        binding.floatingActionButton.setOnClickListener( onFloatingClicked )

    }

    private fun initRecyclerView(){
        binding.rvUsers.layoutManager = LinearLayoutManager(requireContext())
        adapter  = UsersAdapter(usersTemp, onItemSelected)
        binding.rvUsers.adapter = adapter

        CoroutineScope(Dispatchers.Main).launch{
            userVM.getAllUsers().collect { users ->
                users.forEach {
                    Log.d("NM", "user => ${it} ")
                    usersTemp.add(0, it)
                    adapter.notifyItemChanged(0)
                }
            }
        }

    }

    private val onItemSelected = object :  UsersAdapter.ItemListener {
        override fun onBtnClick(user: User) {
            Log.d("NM", "user => ${user}")
        }
    }

    private val onFloatingClicked = object : View.OnClickListener{
        override fun onClick(p0: View?) { addNewUserDialog() }
    }


    private fun addNewUserDialog(){
        val dialog = AddUserDialog(userVM, userDialogListener)
        val fm: FragmentManager = requireActivity().supportFragmentManager
        dialog.show(fm,"custom")
    }

    private val userDialogListener = object : AddUserDialog.UserDialogListener{
        override fun addUser(user: User) {
            usersTemp.add(user)
            adapter.notifyItemInserted(usersTemp.size - 1)
        }
    }


}