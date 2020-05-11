package com.simplute.android.cartaskandroid

import android.app.Application
import com.intuit.sdp.BuildConfig
import timber.log.Timber


/**
 * Controller responsible to start timber debug tree
 * */

class ApplicationController : Application() {
    override fun onCreate() {
        super.onCreate()

        // this condition to prevent logs in release
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}