package com.nicomahnic.heladerakt.data.datasource.database.dao

import androidx.room.*
import com.nicomahnic.heladerakt.data.datasource.database.entity.TasteOptionEntity

@Dao
interface TasteOptionsDao {

    @Query("SELECT * FROM TasteOptions")
    suspend fun getAll(): List<TasteOptionEntity>

    @Query("SELECT * FROM TasteOptions WHERE name = :name")
    suspend fun getByName(name: String): List<TasteOptionEntity>

    @Update
    suspend fun update(taste: TasteOptionEntity)

    @Delete
    suspend fun delete(taste: TasteOptionEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(taste: TasteOptionEntity) : Long

}