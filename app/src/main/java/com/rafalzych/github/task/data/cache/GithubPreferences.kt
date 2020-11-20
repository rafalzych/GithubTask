package com.rafalzych.github.task.data.cache

import android.annotation.SuppressLint
import android.content.Context
import com.rafalzych.github.task.GithubUsersApplication

class GithubPreferences(
    val context: Context,
    prefsFile: String
) : BasePreferences(context, prefsFile) {

    companion object {
        const val GITHUB_USERS_LIST_KEY = "GITHUB_USERS_LIST_KEY"
        fun getInstance() =
            GithubPreferences(GithubUsersApplication.applicationContext(), "githubPrefs")
    }

    var githubUsersList: String?
        get() = preferences.getString(GITHUB_USERS_LIST_KEY, "")
        @SuppressLint("ApplySharedPref")
        set(value) {
            val editor = preferences.edit()
            editor.putString(GITHUB_USERS_LIST_KEY, value)
            editor.commit()
        }
}