package com.example.projecte0alexcharles.network

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

var numeroImatge = Int

private const val BASE_URL = "http://192.168.0.189:26667"
private const val BASE_URL_IMATGE = "http://dam.inspedralbes.cat:26666/sources/Imatges"

private val retrofitText = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

private val retrofitImatge = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL_IMATGE)
    .build()

interface PreguntesAPI {
    @POST("getXPreguntes")
    suspend fun getPreguntesJSON(@Query("num") num: Int): String

    @POST("finalista")
    suspend fun enviarRespostes(
        @Query("id") ids: String,
        @Query("sessionId") uuid: String
    ): String

    fun getImatge(num: Int): String {
        return "$BASE_URL_IMATGE/pregunta_$num.jpg"
    }


    object PreguntesAPi {
        val retrofitService: PreguntesAPI by lazy {
            retrofitText.create(PreguntesAPI::class.java)
        }
    }
    object ImatgesAPi {
        val retrofitService: PreguntesAPI by lazy {
            retrofitImatge.create(PreguntesAPI::class.java)
        }
    }
}
