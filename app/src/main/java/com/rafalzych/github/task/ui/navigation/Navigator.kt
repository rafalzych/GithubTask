package com.rafalzych.github.task.ui.navigation

import com.rafalzych.github.task.ui.MainActivity
import com.rafalzych.github.task.ui.list.UsersListFragment
import com.rafalzych.github.task.util.showFragment

object Navigator {

    fun showGithubUsersListFragment(activity: MainActivity, resetStack: Boolean = false) {
        activity.showFragment(UsersListFragment.newInstance(), resetStack)
    }
}