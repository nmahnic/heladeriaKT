package com.nicomahnic.heladerakt.data.repositories

import com.nicomahnic.heladerakt.domain.models.Order
import com.nicomahnic.heladerakt.data.datasource.database.dao.OrdersDao
import com.nicomahnic.heladerakt.data.datasource.database.dao.UsersDao
import com.nicomahnic.heladerakt.domain.models.mappers.OrderMapper
import com.nicomahnic.heladerakt.domain.models.mappers.UserMapper
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.flow
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class OrdersRepository @Inject constructor(
    private val ordersDao: OrdersDao,
    private val usersDao: UsersDao,
    private val orderMapper: OrderMapper,
    private val userMapper: UserMapper,
) {

    suspend fun getAll() = flow {
        coroutineScope {
            val first = Date().time

            val entityOrders = async { ordersDao.getAll() }
            val entityUsers = async { usersDao.getAll() }

            val orders = orderMapper.mapFromEntityList(entityOrders.await())
            val users = userMapper.mapFromEntityList(entityUsers.await())

            val time = Date().time - first
            val sdf = SimpleDateFormat("ss:SS")
            println("Time spent ${sdf.format(time)} ticks:${time}")

            orders.forEach { order ->
                users.firstOrNull() { order.user.id == it.id }?.let { order.user = it }
            }
            emit(orders)
        }
    }

    suspend fun deleteOrder(id: Int){
        ordersDao.deleteById(id)
    }

    suspend fun insertOrder(order: Order){
        ordersDao.insert(orderMapper.mapToEntity(order))
    }

}