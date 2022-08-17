package com.nicomahnic.heladerakt.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicomahnic.heladerakt.data.repositories.UsersRepository
import com.nicomahnic.heladerakt.domain.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserVM @Inject constructor(
    private val userRepo: UsersRepository
): ViewModel() {

    suspend fun getAllUsers() = userRepo.getAll()

    fun insertUser(user: User){
        viewModelScope.launch {
            userRepo.insert(user)
        }
    }

}