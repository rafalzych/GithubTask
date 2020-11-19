package com.rafalzych.github.task.data

import com.rafalzych.github.task.data.repository.GithubCache
import com.rafalzych.github.task.data.repository.GithubRemote
import com.rafalzych.github.task.model.Repository
import com.rafalzych.github.task.model.User
import io.reactivex.Single

class GithubDataRepository(
    private val githubRemote: GithubRemote,
    private val githubCache: GithubCache
) : GithubRepository {

    override fun getGithubUsers(): Single<List<User>> {
        return githubRemote.getGithubUsers()
    }

    override fun getUsersRepositories(userName: String): Single<List<Repository>> {
        return githubRemote.getUsersRepositories(userName)
    }
}