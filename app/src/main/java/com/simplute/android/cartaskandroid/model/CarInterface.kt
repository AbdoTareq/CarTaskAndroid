package com.simplute.android.cartaskandroid.model

interface CarInterface {
    fun onSuccess(carList: List<Car>)
    fun onFail(responseCode: String)
}

