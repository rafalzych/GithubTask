package com.rafalzych.github.task.data.cache

import com.rafalzych.github.task.data.adapter.GithubUsersListSerializer
import com.rafalzych.github.task.data.repository.GithubCache
import com.rafalzych.github.task.model.CacheUsersList
import io.reactivex.Single

class GithubCacheImpl(
    private val githubPreferences: GithubPreferences = GithubPreferences.getInstance(),
    private val githubUsersListSerializer: GithubUsersListSerializer = GithubUsersListSerializer()
) : GithubCache {

    override fun saveGithubUsersList(githubUsersList: CacheUsersList): Single<Any> {
        return Single.defer {
            githubPreferences.githubUsersList =
                githubUsersListSerializer.serializeGithubUsersList(githubUsersList)
            Single.just(Any())
        }
    }

    override fun getCachedGithubUsersList(): Single<CacheUsersList> {
        return Single.just(
            githubUsersListSerializer.deserializeGithubUsersList(
                githubPreferences.githubUsersList ?: ""
            ) ?: CacheUsersList.empty()
        )
    }
}