package com.rafalzych.github.task.ui.list

import android.os.Bundle
import com.rafalzych.github.task.R
import com.rafalzych.github.task.ui.base.BaseFragment

class UsersListFragment : BaseFragment<UsersListContract.Presenter>(), UsersListContract.View {

    companion object {
        fun newInstance(): UsersListFragment = UsersListFragment()
    }

    override lateinit var presenter: UsersListContract.Presenter

    override fun getLayoutResource(): Int = R.layout.users_list_fragment

    override fun getIdent(): String = "UsersListFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = UsersListPresenter(this)
    }
}