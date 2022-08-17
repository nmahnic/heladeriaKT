package com.nicomahnic.heladerakt.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicomahnic.heladerakt.domain.models.Delivery
import com.nicomahnic.heladerakt.domain.models.IceCreamOption
import com.nicomahnic.heladerakt.domain.models.TasteOption
import com.nicomahnic.heladerakt.data.repositories.DeliveriesRepository
import com.nicomahnic.heladerakt.data.repositories.IceCreamOptionsRepository
import com.nicomahnic.heladerakt.data.repositories.TasteOptionsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InitialVM @Inject constructor(
    private val deliveriesRepo: DeliveriesRepository,
    private val iceCreamOptionRepo: IceCreamOptionsRepository,
    private val tasteOptionsRepo: TasteOptionsRepository,
): ViewModel() {

    fun insertDeliveries(deliveries: List<Delivery>){
        viewModelScope.launch {
            deliveries.forEach {  deliveriesRepo.insert(it) }
        }
    }

    fun insertIceCreamOptions(iceCreamOptions: List<IceCreamOption>){
        viewModelScope.launch {
            iceCreamOptions.forEach {  iceCreamOptionRepo.insert(it) }
        }
    }

    fun insertTasteOptions(tastes: List<TasteOption>){
        viewModelScope.launch {
            tastes.forEach {  tasteOptionsRepo.insert(it) }
        }
    }

}