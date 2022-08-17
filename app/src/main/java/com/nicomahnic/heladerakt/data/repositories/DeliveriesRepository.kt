package com.nicomahnic.heladerakt.data.repositories

import com.nicomahnic.heladerakt.data.datasource.database.dao.DeliveriesDao
import com.nicomahnic.heladerakt.domain.models.mappers.DeliveriesMapper
import com.nicomahnic.heladerakt.domain.models.Delivery
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DeliveriesRepository @Inject constructor(
    private val deliveriesDao: DeliveriesDao,
    private val mapper: DeliveriesMapper,
) {

    suspend fun getAll() = flow {
        val deliveryEntity = deliveriesDao.getAll()
        emit( mapper.mapFromEntityList( deliveryEntity ))
    }

    suspend fun insert(delivery: Delivery){
        val deliveries = deliveriesDao.getByNameAndPhone(delivery.name, delivery.whatsappNumber)
        if(deliveries.isEmpty()) deliveriesDao.insert( mapper.mapToEntity(delivery) )
    }

}