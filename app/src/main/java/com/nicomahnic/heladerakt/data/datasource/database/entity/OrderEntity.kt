package com.nicomahnic.heladerakt.data.datasource.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Orders")
data class OrderEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val userId: Int,
    val comment: String,
    val date: Long,
)