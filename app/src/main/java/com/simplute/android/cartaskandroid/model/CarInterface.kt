package com.simplute.android.cartaskandroid.model

interface CarInterface {
    fun onSuccess(historyTickets: List<Car>)
    fun onFail(responseCode: String)
}

