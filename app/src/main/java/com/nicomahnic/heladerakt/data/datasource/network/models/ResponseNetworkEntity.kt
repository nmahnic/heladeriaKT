package com.nicomahnic.heladerakt.data.datasource.network.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseNetworkEntity(
    val deliveries: List<DeliveriesNetworkEntity>,
    val options: List<IceCremOptionsNetworkEntity>,
    val tastes: List<TasteOptionsNetworkEntity>
) : Parcelable
