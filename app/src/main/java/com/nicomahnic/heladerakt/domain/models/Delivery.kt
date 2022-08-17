package com.nicomahnic.heladerakt.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Delivery(
    val name: String,
    val address: String,
    val whatsappNumber: String,
    val city: String = "",
    val postCode: String = "",
    val date: Long = Date().time,
    val id: Int = 0,
): Parcelable
