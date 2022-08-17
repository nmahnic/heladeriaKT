package com.nicomahnic.heladerakt.domain.models.mappers

import com.nicomahnic.heladerakt.data.datasource.database.EntityMapper
import com.nicomahnic.heladerakt.domain.models.Order
import com.nicomahnic.heladerakt.domain.models.User
import com.nicomahnic.heladerakt.data.datasource.database.entity.OrderEntity
import java.util.*
import javax.inject.Inject

class OrderMapper @Inject constructor(
    private val comboMapper: ComboMapper
) : EntityMapper<OrderEntity, Order> {

    override fun mapFromEntity(entity: OrderEntity): Order {
        return Order(
            id = entity.id,
            user = User(entity.userId),
            date = Date(entity.date),
            comment = entity.comment,
            selected = false,
        )
    }

    override fun mapToEntity(domainModel: Order?): OrderEntity {
        return OrderEntity(
            userId = domainModel!!.user.id,
            comment = domainModel.comment,
            date = domainModel.date.time,
        )
    }

}