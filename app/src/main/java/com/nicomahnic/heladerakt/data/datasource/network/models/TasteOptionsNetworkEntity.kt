package com.nicomahnic.heladerakt.data.datasource.network.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TasteOptionsNetworkEntity(
    val name: String
) : Parcelable
