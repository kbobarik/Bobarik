package com.exaple.api.api

import retrofit2.http.Header
import retrofit2.http.POST

interface API {

    @POST("com/exaple/api/api/SendCode")
    suspend fun sendCodeEmail(@Header("User-email") email: String):String
    //Константа, к которой можно обращаться из любой точки кода, не создавая объект класса (example: Api.BASE_URL)
    companion object {
        val BASE_URL = "https://rickandmortyapi.com/"
        val BASE_URL_SMARTLAB = "https://iis.ngknn.ru/NGKNN/МамшеваЮС/MedicMadlab/"
    }
}