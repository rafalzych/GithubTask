package com.rafalzych.github.task.data.adapter

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.rafalzych.github.task.model.CacheUsersList

class GithubUsersListSerializer(private val gson: Gson = GsonBuilder().create()) {
    fun serializeGithubUsersList(githubUsersList: CacheUsersList): String {
        return gson.toJson(githubUsersList)
    }

    fun deserializeGithubUsersList(githubUsersListString: String?): CacheUsersList? {
        return gson.fromJson(githubUsersListString, CacheUsersList::class.java)
    }
}