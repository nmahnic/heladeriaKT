package com.nicomahnic.heladerakt.di

import com.nicomahnic.heladerakt.data.datasource.network.DataApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitModule {

    private val BASE_URL = "https://raw.githubusercontent.com/nmahnic/heladeriaKT/master/"

    val service : DataApi
        get() {
            val logging = provideOkHttpClientLogging()
            val okHttpClient = provideOkHttpClient(logging)
            val retrofit = provideRetrofit(okHttpClient)
            return getCountriesService(retrofit)
        }

    private fun getCountriesService(retrofit: Retrofit): DataApi {
        return retrofit.create(DataApi::class.java)
    }

    private fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun provideOkHttpClient(logging: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .callTimeout(11, TimeUnit.SECONDS)
            .addInterceptor(logging)
            .build()
    }

    private fun provideOkHttpClientLogging(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }
}