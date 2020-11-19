package com.rafalzych.github.task.ui.base

import androidx.annotation.CallSuper
import io.reactivex.disposables.Disposable

abstract class BasePresenter : BaseContract.Presenter {

    private val disposableMap = HashMap<String, Disposable>()

    @CallSuper
    override fun init() {
    }

    @CallSuper
    override fun start() {
    }

    @CallSuper
    override fun resume() {
    }

    @CallSuper
    override fun pause() {
    }

    @CallSuper
    override fun stop() {
    }

    @CallSuper
    override fun destroyView() {
        dispose()
    }

    @CallSuper
    override fun destroy() {
    }

    protected fun Disposable.addDisposable(tag: String = "DEFAULT") {
        dispose(tag)
        disposableMap[tag] = this
    }

    private fun dispose(tag: String? = null) {
        if (tag == null) {
            disposeAll()
        } else {
            disposeByTag(tag)
        }
    }

    private fun disposeAll() {
        disposableMap.forEach { if (!it.value.isDisposed) it.value.dispose() }
        disposableMap.clear()
    }

    private fun disposeByTag(tag: String) {
        val previous = disposableMap.remove(tag)
        if (previous != null && !previous.isDisposed) {
            previous.dispose()
        }
    }

}