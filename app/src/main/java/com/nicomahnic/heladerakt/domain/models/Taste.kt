package com.nicomahnic.heladerakt.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Taste (
    val name: String,
    val id: Int = 0,
    val order: Order? = null,
) : Parcelable