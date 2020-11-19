package com.rafalzych.github.task.domain.usecase

import com.rafalzych.github.task.data.GithubDataRepository
import com.rafalzych.github.task.data.GithubRepository
import com.rafalzych.github.task.data.cache.GithubCacheImpl
import com.rafalzych.github.task.data.network.GithubRemoteImpl
import com.rafalzych.github.task.model.Repository
import io.reactivex.Single

class GetUserRepositoriesUseCase(private val githubRepository: GithubRepository) :
    SingleUseCase<List<Repository>, GetUserRepositoriesUseCase.GetUserRepositoriesParams>() {

    companion object {
        fun getInstance() =
            GetUserRepositoriesUseCase(GithubDataRepository(GithubRemoteImpl(), GithubCacheImpl()))
    }

    override fun createSingleUseCase(params: GetUserRepositoriesParams?): Single<List<Repository>> {
        return if (params == null) {
            Single.error(IllegalStateException("params should not be null!"))
        } else {
            githubRepository.getUsersRepositories(params.userName);
        }
    }

    data class GetUserRepositoriesParams(val userName: String)
}