package com.nicomahnic.heladerakt.data.datasource.network.mappers

import com.nicomahnic.heladerakt.data.datasource.database.EntityMapper
import com.nicomahnic.heladerakt.domain.models.Delivery
import com.nicomahnic.heladerakt.data.datasource.network.models.DeliveriesNetworkEntity
import java.util.*
import javax.inject.Inject

class DeliveriesNetworkMapper @Inject constructor() : EntityMapper<DeliveriesNetworkEntity, Delivery> {

    override fun mapFromEntity(entity: DeliveriesNetworkEntity): Delivery {
        return Delivery(
            id = 0,
            name = entity.name,
            address = entity.address,
            city = "",
            postCode = "",
            date = Date().time,
            whatsappNumber = entity.whatsappNumber
        )
    }

    override fun mapToEntity(domainModel: Delivery?): DeliveriesNetworkEntity {
        return DeliveriesNetworkEntity(
            name = domainModel!!.name,
            address = domainModel.address,
            whatsappNumber = domainModel.whatsappNumber
        )
    }

}