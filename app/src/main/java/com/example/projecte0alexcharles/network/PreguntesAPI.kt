package com.example.projecte0alexcharles.network

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query


private const val BASE_URL = "http://dam.inspedralbes.cat:26667"
private const val BASE_URL_IMATGE = "http://dam.inspedralbes.cat:26666/sources/Imatges"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

fun getImatge(num: Int): String {
    return "$BASE_URL_IMATGE/pregunta_$num.jpg"
}


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
