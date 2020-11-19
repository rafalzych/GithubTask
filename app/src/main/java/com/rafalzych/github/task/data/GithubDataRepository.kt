package com.rafalzych.github.task.data

import com.rafalzych.github.task.data.repository.GithubCache
import com.rafalzych.github.task.data.repository.GithubRemote
import com.rafalzych.github.task.model.RepositoriesResponse
import com.rafalzych.github.task.model.UsersResponse
import io.reactivex.Single

class GithubDataRepository(
    private val githubRemote: GithubRemote,
    private val githubCache: GithubCache
) : GithubRepository {

    override fun getGithubUsers(): Single<UsersResponse> {
        return githubRemote.getGithubUsers()
    }

    override fun getUsersRepositories(userName: String): Single<RepositoriesResponse> {
        return githubRemote.getUsersRepositories(userName)
    }
}