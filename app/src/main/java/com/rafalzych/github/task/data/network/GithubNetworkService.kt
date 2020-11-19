package com.rafalzych.github.task.data.network

import com.rafalzych.github.task.model.RepositoriesResponse
import com.rafalzych.github.task.model.UsersResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubNetworkService {
    @GET(value = "users")
    fun getGithubUsers(): Single<UsersResponse>

    @GET(value = "users/{userName}/repos")
    fun getUserRepositories(@Path("userName") userName: String): Single<RepositoriesResponse>
}