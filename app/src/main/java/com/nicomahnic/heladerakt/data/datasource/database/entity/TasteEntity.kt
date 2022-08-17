package com.nicomahnic.heladerakt.data.datasource.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Tastes")
data class TasteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val comboId: Int,
    val name: String,
)