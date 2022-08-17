package com.nicomahnic.heladerakt.data.datasource.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "IceCreamOptions")
data class IceCreamOptionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
)