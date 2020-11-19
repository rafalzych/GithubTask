package com.rafalzych.github.task.domain.usecase

import com.rafalzych.github.task.data.GithubDataRepository
import com.rafalzych.github.task.data.GithubRepository
import com.rafalzych.github.task.data.cache.GithubCacheImpl
import com.rafalzych.github.task.data.network.GithubRemoteImpl
import com.rafalzych.github.task.model.UsersResponse
import io.reactivex.Single

class GetUsersListUseCase(private val githubRepository: GithubRepository) :
    SingleUseCase<UsersResponse, Void>() {

    companion object {
        fun getInstance() =
            GetUsersListUseCase(GithubDataRepository(GithubRemoteImpl(), GithubCacheImpl()))
    }

    override fun createSingleUseCase(params: Void?): Single<UsersResponse> {
        return githubRepository.getGithubUsers()
    }
}