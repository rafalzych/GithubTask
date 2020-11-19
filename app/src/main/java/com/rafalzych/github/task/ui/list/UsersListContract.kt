package com.rafalzych.github.task.ui.list

import com.rafalzych.github.task.ui.base.BaseContract

interface UsersListContract {

    interface View : BaseContract.View, BaseContract.ProgressView {

    }

    interface Presenter : BaseContract.Presenter

}