package com.exaple.api.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    val apiSmartLab: API = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(API.BASE_URL_SMARTLAB)
        .client(client)
        .build()
        .create(API::class.java)
}