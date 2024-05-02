package com.blacklotus.makasibbasita.model
import com.google.gson.Gson
import  okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private const val BASE_URL = "back end url"
    private  val okHttp: OkHttpClient.Builder = OkHttpClient.Builder()
    private val builder: Retrofit.Builder = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())


    private val retrofit: Retrofit = builder.build()
    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }
}
