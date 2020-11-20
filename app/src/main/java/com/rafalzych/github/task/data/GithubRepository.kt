package com.rafalzych.github.task.data

import com.rafalzych.github.task.model.CacheUsersList
import com.rafalzych.github.task.model.Repo
import com.rafalzych.github.task.model.User
import io.reactivex.Single

interface GithubRepository {

    fun getGithubUsers(): Single<List<User>>

    fun getUsersRepositories(userName: String): Single<List<Repo>>

    fun saveGithubUsersList(githubUsersList: CacheUsersList): Single<Any>

    fun getCachedGithubUsersList(): Single<CacheUsersList>
}