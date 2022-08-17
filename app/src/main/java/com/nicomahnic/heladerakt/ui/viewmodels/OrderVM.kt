package com.nicomahnic.heladerakt.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicomahnic.heladerakt.data.repositories.OrdersRepository
import com.nicomahnic.heladerakt.domain.models.Order
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderVM @Inject constructor(
    private val orderRepo: OrdersRepository
): ViewModel() {

    var floatingButtonStatus: Boolean = false

    fun combineOrders(selectedOrdersTemp : MutableList<Order>): Order {
        return selectedOrdersTemp[0]
    }

    suspend fun getAllOrders() = orderRepo.getAll()

    fun deleteOrder(id: Int) {
        viewModelScope.launch {
            orderRepo.deleteOrder(id)
        }
    }

}