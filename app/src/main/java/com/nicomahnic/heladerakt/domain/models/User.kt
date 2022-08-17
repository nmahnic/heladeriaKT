package com.nicomahnic.heladerakt.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class User (
    val id: Int = 0,
    val name: String = "",
    val address: String = "",
    val date: Date = Date(),
    var selected: Boolean = false
) : Parcelable