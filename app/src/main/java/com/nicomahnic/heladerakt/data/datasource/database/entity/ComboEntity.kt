package com.nicomahnic.heladerakt.data.datasource.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Combos")
data class ComboEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val orderId: Int,
    val name: String,
    var comment: String,
)