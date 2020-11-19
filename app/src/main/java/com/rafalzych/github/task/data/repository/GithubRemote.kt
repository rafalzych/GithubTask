package com.rafalzych.github.task.data.repository

import com.rafalzych.github.task.model.RepositoriesResponse
import com.rafalzych.github.task.model.UsersResponse
import io.reactivex.Single

interface GithubRemote {
    fun getGithubUsers(): Single<UsersResponse>

    fun getUsersRepositories(userName: String): Single<RepositoriesResponse>
}