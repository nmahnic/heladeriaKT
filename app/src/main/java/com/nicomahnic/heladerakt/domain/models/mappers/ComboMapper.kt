package com.nicomahnic.heladerakt.domain.models.mappers

import com.nicomahnic.heladerakt.domain.models.Combo
import com.nicomahnic.heladerakt.data.datasource.database.EntityMapper
import com.nicomahnic.heladerakt.data.datasource.database.entity.ComboEntity
import javax.inject.Inject

class ComboMapper @Inject constructor(
    private val tasteMapper: TasteMapper
) : EntityMapper<ComboEntity, Combo> {

    override fun mapFromEntity(entity: ComboEntity): Combo {
        return Combo(
            name = entity.name,
            tasteList = listOf(),
            comment = entity.comment,
            orderId = entity.orderId,
        )
    }

    override fun mapToEntity(domainModel: Combo?): ComboEntity {
        return ComboEntity(
            name = domainModel!!.name,
            comment = domainModel.comment,
            orderId = domainModel.orderId
        )
    }

}