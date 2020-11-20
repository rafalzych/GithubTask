package com.rafalzych.github.task.ui.list

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.rafalzych.github.task.R
import com.rafalzych.github.task.model.GithubUser
import com.rafalzych.github.task.ui.base.BaseFragment
import com.rafalzych.github.task.ui.list.adapter.GithubUsersAdapter
import com.rafalzych.github.task.util.hide
import com.rafalzych.github.task.util.show
import kotlinx.android.synthetic.main.users_list_fragment.*

class UsersListFragment : BaseFragment<UsersListContract.Presenter>(), UsersListContract.View {

    companion object {
        fun newInstance(): UsersListFragment = UsersListFragment()
    }

    override lateinit var presenter: UsersListContract.Presenter

    override fun getLayoutResource(): Int = R.layout.users_list_fragment

    override fun getIdent(): String = "UsersListFragment"

    private val githubUsersAdapter = GithubUsersAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = UsersListPresenter(this)
    }

    override fun initView() {
        configureRecyclerView()
    }

    private fun configureRecyclerView() {
        rvGithubUsers.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = githubUsersAdapter
        }
    }

    override fun setDataOnView(result: List<GithubUser>) {
        githubUsersAdapter.setItems(result)
    }

    override fun displayErrorMessage(message: String?) {
        rvGithubUsers.hide()
        tvGithubUsersError.show()
        tvGithubUsersError.text = message
    }

    override fun onDestroyView() {
        rvGithubUsers.adapter = null
        super.onDestroyView()
    }
}