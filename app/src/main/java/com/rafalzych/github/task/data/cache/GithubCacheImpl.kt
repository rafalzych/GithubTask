package com.rafalzych.github.task.data.cache

import com.rafalzych.github.task.data.adapter.GithubUsersListAdapter
import com.rafalzych.github.task.data.repository.GithubCache
import com.rafalzych.github.task.model.CacheUsersList
import io.reactivex.Single

class GithubCacheImpl(
    private val githubPreferences: GithubPreferences = GithubPreferences.getInstance(),
    private val githubUsersListAdapter: GithubUsersListAdapter = GithubUsersListAdapter()
) : GithubCache {

    override fun saveGithubUsersList(githubUsersList: CacheUsersList): Single<Any> {
        return Single.defer {
            githubPreferences.githubUsersList =
                githubUsersListAdapter.serializeGithubUsersList(githubUsersList)
            Single.just(Any())
        }
    }

    override fun getCachedGithubUsersList(): Single<CacheUsersList> {
        return Single.just(
            githubUsersListAdapter.deserializeGithubUsersList(
                githubPreferences.githubUsersList ?: ""
            ) ?: CacheUsersList.empty()
        )
    }
}