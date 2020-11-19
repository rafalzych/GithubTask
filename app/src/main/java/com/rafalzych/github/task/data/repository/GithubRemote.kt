package com.rafalzych.github.task.data.repository

import com.rafalzych.github.task.model.Repo
import com.rafalzych.github.task.model.User
import io.reactivex.Single

interface GithubRemote {
    fun getGithubUsers(): Single<List<User>>

    fun getUsersRepositories(userName: String): Single<List<Repo>>
}