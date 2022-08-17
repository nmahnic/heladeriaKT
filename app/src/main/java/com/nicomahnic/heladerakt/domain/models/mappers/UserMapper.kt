package com.nicomahnic.heladerakt.domain.models.mappers

import com.nicomahnic.heladerakt.data.datasource.database.EntityMapper
import com.nicomahnic.heladerakt.domain.models.User
import com.nicomahnic.heladerakt.data.datasource.database.entity.UserEntity
import java.util.*
import javax.inject.Inject

class UserMapper @Inject constructor() : EntityMapper<UserEntity, User> {

    override fun mapFromEntity(entity: UserEntity): User {
        return User(
            id = entity.id,
            name = entity.name,
            address = entity.address,
            date = Date(entity.date),
        )
    }

    override fun mapToEntity(domainModel: User?): UserEntity {
        return UserEntity(
            name = domainModel!!.name,
            address = domainModel.address,
            date = domainModel.date.time
        )
    }

}