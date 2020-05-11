package com.simplute.android.cartaskandroid.network

import com.simplute.android.cartaskandroid.model.Car
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import retrofit2.http.Query

private const val BASE_URL = "http://demo1286023.mockable.io/api/v1/cars"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface CarApiService {

    @POST("tickets/insertmulti")
    suspend fun getCarList(
        @Query("page") page: Int
    ): List<Car>

}

object CarApiObj {
    val retrofitService: CarApiService by lazy {
        retrofit.create(CarApiService::class.java)
    }
}