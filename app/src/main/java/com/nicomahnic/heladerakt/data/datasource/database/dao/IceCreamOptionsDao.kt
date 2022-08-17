package com.nicomahnic.heladerakt.data.datasource.database.dao

import androidx.room.*
import com.nicomahnic.heladerakt.data.datasource.database.entity.IceCreamOptionEntity

@Dao
interface IceCreamOptionsDao {

    @Query("SELECT * FROM IceCreamOptions")
    suspend fun getAll(): List<IceCreamOptionEntity>

    @Query("SELECT * FROM IceCreamOptions WHERE name = :name")
    suspend fun getByName(name: String): List<IceCreamOptionEntity>

    @Update
    suspend fun update(iceCreamOption: IceCreamOptionEntity)

    @Delete
    suspend fun delete(iceCreamOption: IceCreamOptionEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(iceCreamOption: IceCreamOptionEntity)

}