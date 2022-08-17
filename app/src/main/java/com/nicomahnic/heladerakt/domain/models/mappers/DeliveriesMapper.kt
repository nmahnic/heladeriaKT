package com.nicomahnic.heladerakt.domain.models.mappers

import com.nicomahnic.heladerakt.data.datasource.database.EntityMapper
import com.nicomahnic.heladerakt.domain.models.Delivery
import com.nicomahnic.heladerakt.data.datasource.database.entity.DeliveryEntity
import javax.inject.Inject

class DeliveriesMapper @Inject constructor() : EntityMapper<DeliveryEntity, Delivery> {

    override fun mapFromEntity(entity: DeliveryEntity): Delivery {
        return Delivery(
            id = entity.id,
            name = entity.name,
            address = entity.address,
            city = entity.city,
            postCode = entity.postCode,
            date = entity.date,
            whatsappNumber = entity.whatsappNumber
        )
    }

    override fun mapToEntity(domainModel: Delivery?): DeliveryEntity {
        return DeliveryEntity(
            id = domainModel!!.id,
            name = domainModel.name,
            address = domainModel.address,
            city = domainModel.city,
            postCode = domainModel.postCode,
            date = domainModel.date,
            whatsappNumber = domainModel.whatsappNumber
        )
    }

}