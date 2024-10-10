package com.example.projecte0alexcharles.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.POST
import retrofit2.http.Query

private const val BASE_URL = "http://192.168.0.189:26667"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface PreguntesAPI {
    @POST("getXPreguntes")
    suspend fun getPreguntesJSON(@Query("num") num: Int): String

    @POST("finalista")
    suspend fun enviarRespostes(
        @Query("id") ids: String,
        @Query("sessionId") uuid: String
    ): String

    object PreguntesAPi {
        val retrofitService: PreguntesAPI by lazy {
            retrofit.create(PreguntesAPI::class.java)
        }
    }
}
