package com.nicomahnic.heladerakt.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicomahnic.heladerakt.data.datasource.network.mappers.DeliveriesNetworkMapper
import com.nicomahnic.heladerakt.data.datasource.network.mappers.IceCreamOptionsNetworkMapper
import com.nicomahnic.heladerakt.data.datasource.network.mappers.TasteNetworkMapper
import com.nicomahnic.heladerakt.domain.models.Delivery
import com.nicomahnic.heladerakt.domain.models.IceCreamOption
import com.nicomahnic.heladerakt.domain.models.TasteOption
import com.nicomahnic.heladerakt.data.repositories.DeliveriesRepository
import com.nicomahnic.heladerakt.data.repositories.IceCreamOptionsRepository
import com.nicomahnic.heladerakt.data.repositories.TasteOptionsRepository
import com.nicomahnic.heladerakt.di.RetrofitModule
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InitialVM @Inject constructor(
    private val deliveriesRepo: DeliveriesRepository,
    private val iceCreamOptionRepo: IceCreamOptionsRepository,
    private val tasteOptionsRepo: TasteOptionsRepository,
    private val tasteNetworkMapper: TasteNetworkMapper,
    private val iceCreamOptionsNetworkMapper: IceCreamOptionsNetworkMapper,
    private val deliveriesNetworkMapper: DeliveriesNetworkMapper
): ViewModel() {

    fun getData(){
        viewModelScope.launch {
            val res = RetrofitModule.service.getData()
            Log.d("NM", "RES -> ${res.isSuccessful}")
            val deliveries = deliveriesNetworkMapper.mapFromEntityList(res.body()?.deliveries!!)
            val tastes = tasteNetworkMapper.mapFromEntityList(res.body()?.tastes!!)
            val options = iceCreamOptionsNetworkMapper.mapFromEntityList(res.body()?.options!!)

            insertDeliveries(deliveries)
            insertTasteOptions(tastes)
            insertIceCreamOptions(options)
        }
    }

    private fun insertDeliveries(deliveries: List<Delivery>){
        viewModelScope.launch {
            deliveries.forEach {  deliveriesRepo.insert(it) }
        }
    }

    private fun insertIceCreamOptions(iceCreamOptions: List<IceCreamOption>){
        viewModelScope.launch {
            iceCreamOptions.forEach {  iceCreamOptionRepo.insert(it) }
        }
    }

    private fun insertTasteOptions(tastes: List<TasteOption>){
        viewModelScope.launch {
            tastes.forEach {  tasteOptionsRepo.insert(it) }
        }
    }

}