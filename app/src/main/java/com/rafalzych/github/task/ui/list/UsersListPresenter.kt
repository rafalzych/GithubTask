package com.rafalzych.github.task.ui.list

import com.github.ajalt.timberkt.e
import com.github.ajalt.timberkt.i
import com.rafalzych.github.task.domain.usecase.GetCachedUsersListUseCase
import com.rafalzych.github.task.domain.usecase.GetUsersDataUseCase
import com.rafalzych.github.task.domain.usecase.SaveUsersListUseCase
import com.rafalzych.github.task.domain.usecase.SingleUseCase
import com.rafalzych.github.task.model.CacheUsersList
import com.rafalzych.github.task.model.GithubUser
import com.rafalzych.github.task.ui.base.BasePresenter

class UsersListPresenter(
    val view: UsersListContract.View,
    private val getUsersDataUseCase: GetUsersDataUseCase = GetUsersDataUseCase.getInstance(),
    private val saveUsersListUseCase: SaveUsersListUseCase = SaveUsersListUseCase.getInstance(),
    private val getCachedUsersListUseCase: GetCachedUsersListUseCase = GetCachedUsersListUseCase.getInstance()
) : BasePresenter(),
    UsersListContract.Presenter {

    companion object {
        const val GET_USERS_DATA = "GET_USERS_DATA"
        const val SAVE_USERS_DATA_IN_CACHE = "SAVE_USERS_DATA_IN_CACHE"
        const val GET_USERS_DATA_FROM_CACHE = "GET_USERS_DATA_FROM_CACHE"
    }

    override fun init() {
        super.init()
        view.initView()

        loadUsers()
    }

    private fun loadUsers() {
        getUsersDataUseCase.execute(GetUsersDataSubscriber()).addDisposable(GET_USERS_DATA)
    }

    private fun persistData(usersList: List<GithubUser>) {
        saveUsersListUseCase.execute(SaveUsersListSubscriber(), CacheUsersList(usersList))
            .addDisposable(SAVE_USERS_DATA_IN_CACHE)
    }

    private fun tryToGetDataFromCache() {
        getCachedUsersListUseCase.execute(GetCacheUsersListSubscriber())
            .addDisposable(GET_USERS_DATA_FROM_CACHE)
    }

    inner class GetUsersDataSubscriber : SingleUseCase.Subscriber<List<GithubUser>>() {
        override fun onSuccess(result: List<GithubUser>) {
            i { "UsersListSubscriber onSuccess $result" }
            view.setDataOnView(result)
            persistData(result)
        }

        override fun onError(exp: Throwable) {
            e { "UsersListSubscriber onError: $exp" }
            tryToGetDataFromCache()
        }

        override fun doOnSubscribe() {
            view.showProgress()
        }

        override fun doFinally() {
            view.hideProgress()
        }
    }

    inner class SaveUsersListSubscriber : SingleUseCase.Subscriber<Any>() {
        override fun onSuccess(result: Any) {
            i { "SaveUsersListSubscriber onSuccess data saved" }
        }

        override fun onError(exp: Throwable) {
            e { "SaveUsersListSubscriber onError: $exp" }
            view.displayErrorMessage(exp.message)
        }
    }

    inner class GetCacheUsersListSubscriber : SingleUseCase.Subscriber<CacheUsersList>() {
        override fun onSuccess(result: CacheUsersList) {
            i { "GetCacheUsersListSubscriber onSuccess data retrieved from cache $result" }
            if (result.usersList.isNotEmpty()) {
                view.setDataOnView(result.usersList)
            } else {
                view.displayErrorMessage("Could not load data from cache or list is empty")
            }
        }

        override fun onError(exp: Throwable) {
            e { "GetCacheUsersListSubscriber UsersListSubscriber onError: $exp" }
            view.displayErrorMessage(exp.message ?: "Could not load data from cache")
        }

        override fun doOnSubscribe() {
            view.showProgress()
        }

        override fun doFinally() {
            view.hideProgress()
        }
    }
}