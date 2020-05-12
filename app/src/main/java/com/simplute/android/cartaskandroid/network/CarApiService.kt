package com.simplute.android.cartaskandroid.network

import com.itkacher.okhttpprofiler.OkHttpProfilerInterceptor
import com.simplute.android.cartaskandroid.BuildConfig
import com.simplute.android.cartaskandroid.model.Request
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "http://demo1286023.mockable.io/api/v1/"

interface CarApiService {
    @GET("cars")
    suspend fun getCarList(
        @Query("page") page: Int
    ): Request

}

object CarApiObj {
    val retrofitService: CarApiService by lazy {
        createRetrofit().create(CarApiService::class.java)
    }
}

fun createRetrofit(): Retrofit {
    // this for debugging network calls
    val builder = OkHttpClient.Builder()
    if (BuildConfig.DEBUG) {
        builder.addInterceptor( OkHttpProfilerInterceptor() )
    }
    val client = builder.build()

    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(client)
        .build()
}
