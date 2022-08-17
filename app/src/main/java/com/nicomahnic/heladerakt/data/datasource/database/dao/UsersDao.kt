package com.nicomahnic.heladerakt.data.datasource.database.dao

import androidx.room.*
import com.nicomahnic.heladerakt.data.datasource.database.entity.UserEntity

@Dao
interface UsersDao {

    @Query("SELECT * FROM Users")
    suspend fun getAll(): List<UserEntity>

    @Update
    suspend fun update(user: UserEntity)

    @Delete
    suspend fun delete(user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: UserEntity) : Long

}