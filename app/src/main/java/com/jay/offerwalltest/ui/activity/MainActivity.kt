package com.jay.offerwalltest.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.jay.offerwalltest.R
import com.jay.offerwalltest.databinding.ActivityMainBinding
import com.jay.offerwalltest.di.mainActivity.DaggerMainActivityComponent
import com.jay.offerwalltest.model.ResponseWrapper
import com.jay.offerwalltest.model.record.RequestB
import com.jay.offerwalltest.model.record.ResponseType
import com.jay.offerwalltest.ui.BaseActivity
import com.jay.offerwalltest.ui.fragment.TextFragment
import com.jay.offerwalltest.ui.fragment.WebViewFragment
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerMainActivityComponent.builder().activity(this).build().inject(this)
        super.onCreate(savedInstanceState)
        initBinding()

        mainActivityViewModel.fetchResponseA()
        observeResponseB()
    }

    private fun initBinding() {
        val mainActivityBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainActivityBinding.mainActivityVM = mainActivityViewModel
    }

    private fun observeResponseB() {
        mainActivityViewModel.responseObserver.observe(this,
            Observer { responseWrapper: ResponseWrapper<RequestB> ->
            if (responseWrapper.error != null) {
                Toast.makeText(this, responseWrapper.error.message, Toast.LENGTH_LONG).show()
            } else {
                handleResponseB(responseWrapper)
            }
        })
    }

    private fun handleResponseB(responseWrapper: ResponseWrapper<RequestB>) {

        val response: RequestB? = responseWrapper.response
        response ?: return

        when(response.type){

            ResponseType.TEXT -> {
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, TextFragment.newInstance(response.contents))
                    .commit()
            }
            ResponseType.WEB_VIEW -> {
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, WebViewFragment.newInstance(response.url))
                    .commit()
            }
            ResponseType.GAME -> {
                mainActivityViewModel.fetchNextResponseB()
            }
        }
    }
}