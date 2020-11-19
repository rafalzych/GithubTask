package com.rafalzych.github.task

import android.app.Application
import com.github.ajalt.timberkt.Timber

class GithubUsersApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.LOG_ENABLED) {
            Timber.plant(Timber.DebugTree())
        }
    }
}