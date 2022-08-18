package com.nicomahnic.heladerakt.data.datasource.network

import com.nicomahnic.heladerakt.data.datasource.network.models.ResponseNetworkEntity
import retrofit2.Response
import retrofit2.http.GET

interface DataApi {

    @GET("data.json")
    suspend fun getData(): Response<ResponseNetworkEntity>

}