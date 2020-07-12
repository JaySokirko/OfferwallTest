package com.jay.offerwalltest.ui.activity

import android.view.View
import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import com.jakewharton.rxbinding.view.RxView
import com.jay.offerwalltest.api.OfferwallNetworkRequest
import com.jay.offerwalltest.model.ResponseWrapper
import com.jay.offerwalltest.model.record.RequestA
import com.jay.offerwalltest.model.record.RequestB
import com.jay.offerwalltest.ui.BaseViewModel
import com.jay.offerwalltest.util.iterator.CircularIterator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import rx.Subscription
import java.util.concurrent.TimeUnit

class MainActivityViewModel : BaseViewModel() {

    val responseObserver: MutableLiveData<ResponseWrapper<RequestB>> = MutableLiveData()
    val mainProgressBarVisibility: ObservableInt = ObservableInt()

    private val offerwallNetworkRequest = OfferwallNetworkRequest()
    private val circularIterator = CircularIterator<Int>()

    init {
        mainProgressBarVisibility.set(View.GONE)
    }

    fun fetchResponseA() {
        mainProgressBarVisibility.set(View.VISIBLE)

        val subscribe: Disposable = offerwallNetworkRequest.getResponseA()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            //get only ids from response
            .map { list: List<RequestA> -> list.map { item: RequestA -> item.id } }
            .subscribe(
                { response: List<Int> ->
                    circularIterator.setCollection(response)
                    fetchNextResponseB()
                },

                { error: Throwable ->
                    responseObserver.postValue(ResponseWrapper(error = error))
                    mainProgressBarVisibility.set(View.GONE)
                })

        disposable.add(subscribe)
    }

    fun onNextClick(view: View) {
        val subscribe: Subscription = RxView.clicks(view)
            .throttleFirst(300, TimeUnit.MILLISECONDS)
            .observeOn(rx.android.schedulers.AndroidSchedulers.mainThread())
            .subscribe { fetchNextResponseB() }

        subscription.add(subscribe)
    }

    fun fetchNextResponseB() {
        fetchResponseB(circularIterator.getNext())
    }

    private fun fetchResponseB(id: Int) {
        mainProgressBarVisibility.set(View.VISIBLE)

        val subscribe: Disposable = offerwallNetworkRequest.getResponseB(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response: RequestB -> responseObserver.postValue(ResponseWrapper(response)) },

                { error: Throwable -> responseObserver.postValue(ResponseWrapper(error = error)) },

                { mainProgressBarVisibility.set(View.GONE) })

        disposable.add(subscribe)
    }
}
