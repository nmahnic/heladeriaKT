package com.nicomahnic.heladerakt.ui.dialog

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputLayout
import com.nicomahnic.heladerakt.R
import com.nicomahnic.heladerakt.databinding.AddUserDialogBinding
import com.nicomahnic.heladerakt.domain.models.User
import com.nicomahnic.heladerakt.ui.viewmodels.UserVM

class AddUserDialog (
    private val userVM: UserVM,
    private val userDialogListener: UserDialogListener
): DialogFragment() {

    lateinit var binding: AddUserDialogBinding

    interface UserDialogListener{
        fun addUser(user: User)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = AddUserDialogBinding.inflate(LayoutInflater.from(requireContext()))

        var userName = ""
        var userAddress = ""

        return MaterialAlertDialogBuilder(requireContext())
            .setTitle("Crear nuevo perfil")
            .setPositiveButton("Aceptar") { dialog, _ ->
                val d = dialog as Dialog
                val tilUserName = d.findViewById<TextInputLayout>(R.id.tilUserName)
                val tilUserAddress = d.findViewById<TextInputLayout>(R.id.tilUserAddress)
                tilUserName.editText?.let { edtUserName ->
                    userName = edtUserName.text.toString()
                   Log.d("NM", "edtUserName $userName")
                }
                tilUserAddress.editText?.let { edtUserAddress ->
                    userAddress = edtUserAddress.text.toString()
                    Log.d("NM", "edtUserAddress $userAddress")
                }
                if( userName.isNotEmpty() &&
                    userAddress.isNotEmpty()
                ){
                    val user = User(
                        name = userName,
                        address = userAddress,
                    )
                    userVM.insertUser(user)
                    userDialogListener.addUser(user)
                }
                dialog.dismiss()
            }
            .setView(binding.root)
            .create()
    }

}