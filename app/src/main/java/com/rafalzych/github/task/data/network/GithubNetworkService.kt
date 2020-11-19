package com.rafalzych.github.task.data.network

import com.rafalzych.github.task.model.Repository
import com.rafalzych.github.task.model.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubNetworkService {
    @GET(value = "users")
    fun getGithubUsers(): Single<List<User>>

    @GET(value = "users/{userName}/repos")
    fun getUserRepositories(@Path("userName") userName: String): Single<List<Repository>>
}