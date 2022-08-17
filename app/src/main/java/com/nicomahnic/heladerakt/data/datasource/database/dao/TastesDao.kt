package com.nicomahnic.heladerakt.data.datasource.database.dao

import androidx.room.*
import com.nicomahnic.heladerakt.data.datasource.database.entity.TasteEntity

@Dao
interface TastesDao {

    @Query("SELECT * FROM Tastes")
    suspend fun getAll(): List<TasteEntity>

    @Update
    suspend fun update(taste: TasteEntity)

    @Delete
    suspend fun delete(taste: TasteEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(taste: TasteEntity) : Long

}