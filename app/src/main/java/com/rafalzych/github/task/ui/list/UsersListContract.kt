package com.rafalzych.github.task.ui.list

import com.rafalzych.github.task.model.GithubUser
import com.rafalzych.github.task.ui.base.BaseContract

interface UsersListContract {

    interface View : BaseContract.View, BaseContract.ProgressView {
        fun initView()
        fun setDataOnView(result: List<GithubUser>)
        fun displayErrorMessage(message: String?)

    }

    interface Presenter : BaseContract.Presenter

}