package com.rafalzych.github.task.model

import com.google.gson.annotations.SerializedName

data class User(val login: String?, @SerializedName(value = "avatar_url") val avatarUrl: String?)