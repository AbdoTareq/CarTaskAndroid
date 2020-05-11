package com.simplute.android.cartaskandroid.model

import android.app.Application
import com.simplute.android.cartaskandroid.R


class ErrorStatus {
    object Codes {

        private const val SocketTimeoutServerOffline = "-2"

        private const val Forbidden = "403"


        fun getErrorMessage(errorCode: String, applicationCon: Application): String {
            return when (errorCode) {
                Forbidden -> applicationCon.getString(R.string.forbidden_mess)
                SocketTimeoutServerOffline -> applicationCon.getString(R.string.server_offline_try)


                else -> errorCode
            }
        }

    }

}