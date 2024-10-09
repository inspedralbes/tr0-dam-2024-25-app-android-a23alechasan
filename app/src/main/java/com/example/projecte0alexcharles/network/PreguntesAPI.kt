package com.example.projecte0alexcharles.network
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

private const val BASE_URL =
    "http://192.168.0.189:26667"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface PreguntesAPI {
    @FormUrlEncoded
    @POST("getXPreguntes")
    suspend fun getPreguntesJSON(@Field("num") num: Int): String


    object PreguntesAPi {
        val retrofitService: PreguntesAPI by lazy {
            retrofit.create(PreguntesAPI::class.java)
        }
    }
}

