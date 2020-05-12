package com.simplute.android.cartaskandroid.model

import com.google.gson.annotations.SerializedName


data class Car(
    @SerializedName("id") val id: Int,
    @SerializedName("brand") val brand: String? = null,
    @SerializedName("constructionYear") val constructionYear: String? = null,

    @SerializedName("imageUrl") val imageUrl: String? = null,
    @SerializedName("isUsed") val isUsed: Boolean

)