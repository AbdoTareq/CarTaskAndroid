package com.simplute.android.cartaskandroid.model

import com.google.gson.annotations.SerializedName


data class Request(
    @SerializedName("status") val status: Int,
    @SerializedName("data") val data: List<Car>


)