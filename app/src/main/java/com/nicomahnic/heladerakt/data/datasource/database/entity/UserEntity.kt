package com.nicomahnic.heladerakt.data.datasource.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val address: String,
    val date: Long
)