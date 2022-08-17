package com.nicomahnic.heladerakt.data.repositories

import com.nicomahnic.heladerakt.domain.models.Taste
import com.nicomahnic.heladerakt.domain.models.mappers.TasteMapper
import com.nicomahnic.heladerakt.data.datasource.database.dao.TastesDao
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TastesRepository @Inject constructor(
    private val tastesDao: TastesDao,
    private val mapper: TasteMapper,
) {

    suspend fun getAll() = flow {
        val tasteEntity = tastesDao.getAll()
        emit( mapper.mapFromEntityList( tasteEntity ))
    }

    suspend fun insert(taste: Taste){
        tastesDao.insert( mapper.mapToEntity(taste) )
    }

}