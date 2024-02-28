package com.exaple.api.api

import retrofit2.http.Header
import retrofit2.http.POST

interface API {

    @POST("/api/SendCode")
    suspend fun sendCodeEmail(@Header("User-email") email: String):String

    companion object {
        val BASE_URL_SMARTLAB = "https://iis.ngknn.ru/NGKNN/МамшеваЮС/MedicMadlab/"
    }
}