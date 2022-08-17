package com.nicomahnic.heladerakt.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.nicomahnic.heladerakt.data.repositories.DeliveriesRepository
import com.nicomahnic.heladerakt.domain.models.Order
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DeliveryVM @Inject constructor(
    private val deliveriesRepo: DeliveriesRepository
): ViewModel() {

    fun createMessage(paymentMethod: String, order: Order) : String {

        var text = "Buenas noches queria hacerte un pedido para *Sarasasa 123*\n"
        order.combosList.forEach {
            text += "${it.name}\n"
        }
        text += "Pago con ${paymentMethod}, gracias!\n"

        return text
    }

    suspend fun getAllDeliveries() = deliveriesRepo.getAll()

}