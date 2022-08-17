package com.nicomahnic.heladerakt.domain.models.mappers

import com.nicomahnic.heladerakt.data.datasource.database.EntityMapper
import com.nicomahnic.heladerakt.domain.models.IceCreamOption
import com.nicomahnic.heladerakt.data.datasource.database.entity.IceCreamOptionEntity
import javax.inject.Inject

class IceCreamOptionMapper @Inject constructor() : EntityMapper<IceCreamOptionEntity, IceCreamOption> {

    override fun mapFromEntity(entity: IceCreamOptionEntity): IceCreamOption {
        return IceCreamOption(
            name = entity.name,
        )
    }

    override fun mapToEntity(domainModel: IceCreamOption?): IceCreamOptionEntity {
        return IceCreamOptionEntity(
            name = domainModel!!.name,
        )
    }

}