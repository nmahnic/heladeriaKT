package com.nicomahnic.heladerakt.domain.models.mappers

import com.nicomahnic.heladerakt.domain.models.Taste
import com.nicomahnic.heladerakt.data.datasource.database.entity.TasteEntity
import com.nicomahnic.heladerakt.data.datasource.database.EntityMapper
import javax.inject.Inject

class TasteMapper @Inject constructor() : EntityMapper<TasteEntity, Taste> {

    override fun mapFromEntity(entity: TasteEntity): Taste {
        return Taste(
            id = entity.id,
            name = entity.name,
        )
    }

    override fun mapToEntity(domainModel: Taste?): TasteEntity {
        return TasteEntity(
            name = domainModel!!.name,
            comboId = 0
        )
    }

}