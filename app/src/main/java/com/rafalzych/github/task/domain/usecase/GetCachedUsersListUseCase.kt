package com.rafalzych.github.task.domain.usecase

import com.rafalzych.github.task.data.GithubDataRepository
import com.rafalzych.github.task.data.GithubRepository
import com.rafalzych.github.task.data.cache.GithubCacheImpl
import com.rafalzych.github.task.data.network.GithubRemoteImpl
import com.rafalzych.github.task.model.CacheUsersList
import io.reactivex.Single

class GetCachedUsersListUseCase(
    private val githubRepository: GithubRepository
) : SingleUseCase<CacheUsersList, Void>() {

    companion object {
        fun getInstance() =
            GetCachedUsersListUseCase(GithubDataRepository(GithubRemoteImpl(), GithubCacheImpl()))
    }

    override fun createSingleUseCase(params: Void?): Single<CacheUsersList> {
        return githubRepository.getCachedGithubUsersList()
    }
}