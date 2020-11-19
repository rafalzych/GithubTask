package com.rafalzych.github.task.data

import com.rafalzych.github.task.model.Repository
import com.rafalzych.github.task.model.User
import io.reactivex.Single

interface GithubRepository {

    fun getGithubUsers(): Single<List<User>>

    fun getUsersRepositories(userName: String): Single<List<Repository>>
}