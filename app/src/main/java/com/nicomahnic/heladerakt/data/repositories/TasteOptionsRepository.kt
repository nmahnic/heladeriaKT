package com.nicomahnic.heladerakt.data.repositories

import com.nicomahnic.heladerakt.domain.models.TasteOption
import com.nicomahnic.heladerakt.domain.models.mappers.TasteOptionMapper
import com.nicomahnic.heladerakt.data.datasource.database.dao.TasteOptionsDao
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TasteOptionsRepository @Inject constructor(
    private val tasteOptionsDao: TasteOptionsDao,
    private val mapper: TasteOptionMapper,
) {

    suspend fun getAll() = flow {
        val tasteEntity = tasteOptionsDao.getAll()
        emit( mapper.mapFromEntityList( tasteEntity ))
    }

    suspend fun insert(taste: TasteOption){
        val tastes = tasteOptionsDao.getByName(taste.name)
        if(tastes.isEmpty()) tasteOptionsDao.insert( mapper.mapToEntity(taste) )
    }

}