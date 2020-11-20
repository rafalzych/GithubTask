package com.rafalzych.github.task.data.repository

import com.rafalzych.github.task.model.CacheUsersList
import io.reactivex.Single

interface GithubCache {

    fun saveGithubUsersList(githubUsersList: CacheUsersList): Single<Any>

    fun getCachedGithubUsersList(): Single<CacheUsersList>

}