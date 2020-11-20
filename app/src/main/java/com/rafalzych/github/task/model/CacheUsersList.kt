package com.rafalzych.github.task.model

data class CacheUsersList(val usersList: List<GithubUser>) {

    companion object {
        fun empty() = CacheUsersList(listOf())
    }
}