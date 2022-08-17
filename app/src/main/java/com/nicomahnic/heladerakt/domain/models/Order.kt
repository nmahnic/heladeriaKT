package com.nicomahnic.heladerakt.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Order(
    var user: User,
    val date: Date,
    val comment: String,
    var selected: Boolean,
    var combosList: MutableList<Combo> = mutableListOf(),
    val id: Int = 0,
) : Parcelable