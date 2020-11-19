package com.rafalzych.github.task.model

data class GithubUser(
    val userName: String?,
    val userAvatarUrl: String?,
    val userRepositories: List<Repo>?
)