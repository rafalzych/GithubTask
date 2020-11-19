package com.rafalzych.github.task.ui.base

interface BaseContract {

    interface Presenter {
        fun init()
        fun start()
        fun resume()
        fun pause()
        fun stop()
        fun destroyView()
        fun destroy()
    }

    interface View {
        fun getLayoutResource(): Int
        fun getIdent(): String
    }

    interface ProgressView {
        fun showProgress()
        fun hideProgress()
    }

}