package com.rafalzych.github.task.data

import com.rafalzych.github.task.data.repository.GithubCache
import com.rafalzych.github.task.data.repository.GithubRemote
import com.rafalzych.github.task.model.CacheUsersList
import com.rafalzych.github.task.model.Repo
import com.rafalzych.github.task.model.User
import io.reactivex.Single

class GithubDataRepository(
    private val githubRemote: GithubRemote,
    private val githubCache: GithubCache
) : GithubRepository {

    override fun getGithubUsers(): Single<List<User>> {
        return githubRemote.getGithubUsers()
    }

    override fun getUsersRepositories(userName: String): Single<List<Repo>> {
        return githubRemote.getUsersRepositories(userName)
    }

    override fun saveGithubUsersList(githubUsersList: CacheUsersList): Single<Any> {
        return githubCache.saveGithubUsersList(githubUsersList)
    }

    override fun getCachedGithubUsersList(): Single<CacheUsersList> {
        return githubCache.getCachedGithubUsersList()
    }
}