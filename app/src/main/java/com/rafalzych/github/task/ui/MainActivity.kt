package com.rafalzych.github.task.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rafalzych.github.task.R
import com.rafalzych.github.task.ui.base.BaseContract
import com.rafalzych.github.task.ui.base.BaseFragment
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

    override fun onBackPressed() {
        if (getCurrentFragment() == null) {
            super.onBackPressed()
            return
        }

        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
        } else {
            onSingleFragmentBackPressed()
        }
    }

    private fun onSingleFragmentBackPressed() {
        finish()
    }

    private fun getCurrentFragment(): BaseFragment<*>? {
        if (supportFragmentManager.backStackEntryCount > 0) {
            val currentFragmentIndex = supportFragmentManager.backStackEntryCount - 1
            val currentFragmentName =
                supportFragmentManager.getBackStackEntryAt(currentFragmentIndex).name
            return supportFragmentManager.findFragmentByTag(currentFragmentName) as? BaseFragment<*>
        }
        return null
    }
}