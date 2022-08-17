package com.nicomahnic.heladerakt.data.repositories

import com.nicomahnic.heladerakt.data.datasource.database.dao.UsersDao
import com.nicomahnic.heladerakt.domain.models.mappers.UserMapper
import com.nicomahnic.heladerakt.domain.models.User
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class UsersRepository @Inject constructor(
    private val usersDao: UsersDao,
    private val mapper: UserMapper,
) {

    suspend fun getAll() = flow {
        val userEntity = usersDao.getAll()
        emit( mapper.mapFromEntityList( userEntity ))
    }

    suspend fun insert(user: User){
        usersDao.insert( mapper.mapToEntity(user) )
    }

}