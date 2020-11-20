package com.rafalzych.github.task.domain.usecase

import com.rafalzych.github.task.data.GithubDataRepository
import com.rafalzych.github.task.data.GithubRepository
import com.rafalzych.github.task.data.cache.GithubCacheImpl
import com.rafalzych.github.task.data.network.GithubRemoteImpl
import com.rafalzych.github.task.model.CacheUsersList
import io.reactivex.Single

class SaveUsersListUseCase(
    private val githubRepository: GithubRepository
) : SingleUseCase<Any, CacheUsersList>() {

    companion object {
        fun getInstance() =
            SaveUsersListUseCase(GithubDataRepository(GithubRemoteImpl(), GithubCacheImpl()))
    }

    override fun createSingleUseCase(params: CacheUsersList?): Single<Any> {
        return if (params == null) {
            Single.error(IllegalStateException("params should not be null!"))
        } else {
            githubRepository.saveGithubUsersList(params)
        }
    }
}