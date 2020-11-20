package com.rafalzych.github.task.domain.usecase

import com.rafalzych.github.task.data.GithubDataRepository
import com.rafalzych.github.task.data.GithubRepository
import com.rafalzych.github.task.data.cache.GithubCacheImpl
import com.rafalzych.github.task.data.network.GithubRemoteImpl
import com.rafalzych.github.task.model.GithubUser
import io.reactivex.Single

class GetUsersDataUseCase(
    private val githubRepository: GithubRepository
) : SingleUseCase<List<GithubUser>, Void>() {

    companion object {
        fun getInstance() =
            GetUsersDataUseCase(GithubDataRepository(GithubRemoteImpl(), GithubCacheImpl()))
    }

    override fun createSingleUseCase(params: Void?): Single<List<GithubUser>> {
        return githubRepository.getGithubUsers().toObservable()
            .flatMapIterable { it }
            .flatMap { user ->
                githubRepository.getUsersRepositories(user.login ?: "").map { repos ->
                    GithubUser(user.login, user.avatarUrl, repos.take(3))
                }.toObservable()
            }.toList()
    }
}