package com.nicomahnic.heladerakt.data.repositories

import com.nicomahnic.heladerakt.domain.models.IceCreamOption
import com.nicomahnic.heladerakt.domain.models.mappers.IceCreamOptionMapper
import com.nicomahnic.heladerakt.data.datasource.database.dao.IceCreamOptionsDao
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class IceCreamOptionsRepository @Inject constructor(
    private val iceCreamOptionsDao: IceCreamOptionsDao,
    private val mapper: IceCreamOptionMapper,
) {

    suspend fun insert(iceCreamOption: IceCreamOption){
        val iceCreamOptions = iceCreamOptionsDao.getByName(iceCreamOption.name)
        if(iceCreamOptions.isEmpty()) iceCreamOptionsDao.insert( mapper.mapToEntity(iceCreamOption) )
    }

    suspend fun getAll() = flow {
        val tasteEntity = iceCreamOptionsDao.getAll()
        emit( mapper.mapFromEntityList( tasteEntity ))
    }

}