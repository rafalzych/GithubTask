package com.rafalzych.github.task.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rafalzych.github.task.R
import com.rafalzych.github.task.ui.base.BaseContract
import com.rafalzych.github.task.ui.navigation.Navigator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BaseContract.ProgressView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showUsersListFragment()
    }

    private fun showUsersListFragment() {
        Navigator.showGithubUsersListFragment(this)
    }

    override fun showProgress() {
        vProgressView.show()
    }

    override fun hideProgress() {
        vProgressView.hide()
    }
}