package com.rafalzych.github.task.data.cache

import android.content.Context
import android.content.SharedPreferences
import com.github.ajalt.timberkt.d

abstract class BasePreferences(context: Context, prefsFile: String) {

    protected val preferences: SharedPreferences =
        context.getSharedPreferences(prefsFile, Context.MODE_PRIVATE)

    fun contains(prefsKey: String): Boolean = preferences.contains(prefsKey)

    fun clear(waitForResult: Boolean = false) {
        if (waitForResult) {
            if (!preferences.edit().clear().commit()) {
                d { "cannot clear preferences!" }
            }
        } else {
            preferences.edit().clear().apply()
        }
    }

}