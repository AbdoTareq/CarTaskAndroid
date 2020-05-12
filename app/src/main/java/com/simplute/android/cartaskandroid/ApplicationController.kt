package com.simplute.android.cartaskandroid

import android.app.Application
import timber.log.Timber


/**
 * Controller responsible to start timber debug tree
 * */

class ApplicationController : Application() {
    override fun onCreate() {
        super.onCreate()

        // this condition to prevent logs in release
        // take care BuildConfig.DEBUG shouldn't import from libraries to work
        if (com.simplute.android.cartaskandroid.BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}