package com.jay.offerwalltest.ui

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import rx.Subscriber
import rx.Subscription
import rx.subscriptions.CompositeSubscription

abstract class BaseViewModel : ViewModel() {

    protected val disposable = CompositeDisposable()
    protected val subscription = CompositeSubscription()

    override fun onCleared() {
        disposable.clear()
        subscription.clear()
        super.onCleared()
    }
}