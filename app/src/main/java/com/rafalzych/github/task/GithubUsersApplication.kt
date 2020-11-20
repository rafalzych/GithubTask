package com.rafalzych.github.task

import android.app.Application
import android.content.Context
import com.github.ajalt.timberkt.Timber

class GithubUsersApplication : Application() {

    init {
        instance = this
    }

    //This is very bad, doing this only because lack of time for proper DI
    companion object {
        private var instance: GithubUsersApplication? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.LOG_ENABLED) {
            Timber.plant(Timber.DebugTree())
        }
    }
}