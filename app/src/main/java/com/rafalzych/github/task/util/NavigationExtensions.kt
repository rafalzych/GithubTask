package com.rafalzych.github.task.util

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.rafalzych.github.task.R
import com.rafalzych.github.task.ui.base.BaseFragment

fun FragmentActivity.clearStack() {
    supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
}

fun FragmentActivity.showFragment(
    fragment: BaseFragment<*>,
    resetStack: Boolean = false
) {
    if (resetStack) {
        clearStack()
    }

    val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
    fragmentTransaction.replace(R.id.vgFragmentContainer, fragment, fragment.getIdent())
    fragmentTransaction.addToBackStack(fragment.getIdent())

    if (!isFinishing) {
        fragmentTransaction.commit()
    }
}