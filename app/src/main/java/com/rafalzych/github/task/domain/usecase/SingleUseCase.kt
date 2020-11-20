package com.rafalzych.github.task.domain.usecase

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

abstract class SingleUseCase<T, in Params> {

    abstract fun createSingleUseCase(params: Params? = null): Single<T>

    fun execute(subscriber: Subscriber<T>, params: Params? = null): Disposable {
        return this.createSingleUseCase(params)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { subscriber.doOnSubscribe() }
            .doFinally { subscriber.doFinally() }
            .subscribe(subscriber::onSuccess, subscriber::onError)
    }

    abstract class Subscriber<T> {
        abstract fun onSuccess(result: T)
        abstract fun onError(exp: Throwable)
        open fun doOnSubscribe() {}
        open fun doFinally() {}
    }
}