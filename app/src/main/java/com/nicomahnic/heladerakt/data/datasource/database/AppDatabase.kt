package com.nicomahnic.heladerakt.data.datasource.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nicomahnic.heladerakt.data.datasource.database.entity.*
import com.nicomahnic.heladerakt.data.datasource.database.dao.*

@Database( entities = [
    IceCreamOptionEntity::class, OrderEntity::class,
    UserEntity::class, DeliveryEntity::class,
    TasteOptionEntity::class, TasteEntity::class
], version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object{
        const val DATABASE_NAME: String = "helados_db"
    }

    abstract fun iceCreamOptionsDao(): IceCreamOptionsDao
    abstract fun orderDao(): OrdersDao
    abstract fun usersDao(): UsersDao
    abstract fun deliveriesDao(): DeliveriesDao
    abstract fun tastesDao(): TastesDao
    abstract fun tasteOptionsDao(): TasteOptionsDao
}