package com.nicomahnic.heladerakt.data.datasource.database.dao

import androidx.room.*
import com.nicomahnic.heladerakt.data.datasource.database.entity.DeliveryEntity

@Dao
interface DeliveriesDao {

    @Query("SELECT * FROM Deliveries")
    suspend fun getAll(): List<DeliveryEntity>

    @Query("SELECT * FROM Deliveries WHERE name = :name AND whatsappNumber = :whatsappNumber")
    suspend fun getByNameAndPhone(name:String, whatsappNumber: String): List<DeliveryEntity>

    @Update
    suspend fun update(user: DeliveryEntity)

    @Delete
    suspend fun delete(user: DeliveryEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: DeliveryEntity) : Long

}