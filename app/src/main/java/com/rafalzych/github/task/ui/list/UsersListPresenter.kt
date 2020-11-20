package com.rafalzych.github.task.ui.list

import com.github.ajalt.timberkt.e
import com.github.ajalt.timberkt.i
import com.rafalzych.github.task.domain.usecase.GetUsersDataUseCase
import com.rafalzych.github.task.domain.usecase.SingleUseCase
import com.rafalzych.github.task.model.GithubUser
import com.rafalzych.github.task.ui.base.BasePresenter

class UsersListPresenter(
    val view: UsersListContract.View,
    private val getUsersDataUseCase: GetUsersDataUseCase = GetUsersDataUseCase.getInstance()
) : BasePresenter(),
    UsersListContract.Presenter {

    companion object {
        const val GET_USERS_DATA = "GET_USERS_DATA"
    }

    override fun init() {
        super.init()
        view.initView()
        loadUsers()
    }

    private fun loadUsers() {
        getUsersDataUseCase.execute(UsersListSubscriber()).addDisposable(GET_USERS_DATA)
    }

    inner class UsersListSubscriber : SingleUseCase.Subscriber<List<GithubUser>>() {
        override fun onSuccess(result: List<GithubUser>) {
            i { "onSuccess $result" }
            view.setDataOnView(result)
        }

        override fun onError(exp: Throwable) {
            e { "UsersListSubscriber onError: $exp" }
            view.displayErrorMessage(exp.message)
        }

        override fun doOnSubscribe() {
            view.showProgress()
        }

        override fun doFinally() {
            view.hideProgress()
        }
    }
}