package com.nicomahnic.heladerakt.data.datasource.network.mappers

import com.nicomahnic.heladerakt.data.datasource.database.EntityMapper
import com.nicomahnic.heladerakt.domain.models.TasteOption
import com.nicomahnic.heladerakt.data.datasource.network.models.TasteOptionsNetworkEntity
import javax.inject.Inject

class TasteNetworkMapper @Inject constructor() : EntityMapper<TasteOptionsNetworkEntity, TasteOption> {

    override fun mapFromEntity(entity: TasteOptionsNetworkEntity): TasteOption {
        return TasteOption(
            id = 0,
            name = entity.name,
        )
    }

    override fun mapToEntity(domainModel: TasteOption?): TasteOptionsNetworkEntity {
        return TasteOptionsNetworkEntity(
            name = domainModel!!.name,
        )
    }

}