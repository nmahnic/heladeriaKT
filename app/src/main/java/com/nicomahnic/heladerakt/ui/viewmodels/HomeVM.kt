package com.nicomahnic.heladerakt.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicomahnic.heladerakt.domain.models.Combo
import com.nicomahnic.heladerakt.domain.models.Order
import com.nicomahnic.heladerakt.data.repositories.UsersRepository
import com.nicomahnic.heladerakt.domain.models.User
import com.nicomahnic.heladerakt.data.repositories.IceCreamOptionsRepository
import com.nicomahnic.heladerakt.data.repositories.OrdersRepository
import com.nicomahnic.heladerakt.data.repositories.TasteOptionsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(
    private val userRepo: UsersRepository,
    private val tasteOptionsRepo: TasteOptionsRepository,
    private val ordersRepo: OrdersRepository,
    private val iceCreamOptionRepo: IceCreamOptionsRepository,
): ViewModel() {

    fun insertCombos(combos: MutableList<Combo>, comment: String, user: User){
        Log.d("NM","HomeVM -> $combos")
        Log.d("NM","HomeVM -> $comment")
        Log.d("NM","HomeVM -> $user")
        viewModelScope.launch {
         ordersRepo.insertOrder( Order(user, Date(), comment, false, combos) )
        }
    }

    suspend fun getAllUsers() = userRepo.getAll()

    suspend fun getAllIceCreamOptions() = iceCreamOptionRepo.getAll()

    suspend fun getAllTastesOptions() = tasteOptionsRepo.getAll()

}