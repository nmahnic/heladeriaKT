package com.nicomahnic.heladerakt.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Combo (
    val name: String,
    var tasteList: List<Taste> = listOf(),
    var comment: String = "",
    val orderId: Int = 0
) : Parcelable