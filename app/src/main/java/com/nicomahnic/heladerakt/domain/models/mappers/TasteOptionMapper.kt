package com.nicomahnic.heladerakt.domain.models.mappers

import com.nicomahnic.heladerakt.domain.models.TasteOption
import com.nicomahnic.heladerakt.data.datasource.database.EntityMapper
import com.nicomahnic.heladerakt.data.datasource.database.entity.TasteOptionEntity
import javax.inject.Inject

class TasteOptionMapper @Inject constructor() : EntityMapper<TasteOptionEntity, TasteOption> {

    override fun mapFromEntity(entity: TasteOptionEntity): TasteOption {
        return TasteOption(
            id = entity.id,
            name = entity.name,
        )
    }

    override fun mapToEntity(domainModel: TasteOption?): TasteOptionEntity {
        return TasteOptionEntity(
            name = domainModel!!.name,
            comboId = 0
        )
    }

}