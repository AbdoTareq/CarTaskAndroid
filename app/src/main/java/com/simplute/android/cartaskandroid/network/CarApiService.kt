package com.simplute.android.cartaskandroid.network

import com.simplute.android.cartaskandroid.model.Request
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "http://demo1286023.mockable.io/api/v1/"

private val httpLoggingInterceptor =
    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS)

private val okHttpClient = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()


private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .client(okHttpClient)
    .build()

interface CarApiService {
    @GET("cars")
    suspend fun getCarList(
        @Query("page") page: Int
    ): Request

}

object CarApiObj {
    val retrofitService: CarApiService by lazy {
        retrofit.create(CarApiService::class.java)
    }
}