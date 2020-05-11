package com.simplute.android.cartaskandroid.network

import com.simplute.android.cartaskandroid.model.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "http://demo1286023.mockable.io/api/v1/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
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