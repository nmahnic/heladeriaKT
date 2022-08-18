package com.nicomahnic.heladerakt.data.datasource.network.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DeliveriesNetworkEntity(
    val name: String,
    val address: String,
    val whatsappNumber: String,
) : Parcelable
