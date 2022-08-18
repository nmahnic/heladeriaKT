package com.nicomahnic.heladerakt.data.datasource.network.mappers

import com.nicomahnic.heladerakt.data.datasource.database.EntityMapper
import com.nicomahnic.heladerakt.domain.models.IceCreamOption
import com.nicomahnic.heladerakt.data.datasource.network.models.IceCremOptionsNetworkEntity
import javax.inject.Inject

class IceCreamOptionsNetworkMapper @Inject constructor() : EntityMapper<IceCremOptionsNetworkEntity, IceCreamOption> {

    override fun mapFromEntity(entity: IceCremOptionsNetworkEntity): IceCreamOption {
        return IceCreamOption(
            name = entity.name,
        )
    }

    override fun mapToEntity(domainModel: IceCreamOption?): IceCremOptionsNetworkEntity {
        return IceCremOptionsNetworkEntity(
            name = domainModel!!.name,
        )
    }

}