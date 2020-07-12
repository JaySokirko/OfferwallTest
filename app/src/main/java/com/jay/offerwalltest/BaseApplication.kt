package com.jay.offerwalltest

import android.app.Application
import com.jay.currencyconverter.di.base.BaseComponent
import com.jay.currencyconverter.di.base.BaseModule
import com.jay.currencyconverter.di.base.DaggerBaseComponent
import com.jay.offerwalltest.di.network.DaggerNetworkComponent
import com.jay.offerwalltest.di.network.NetworkComponent

class BaseApplication: Application() {

    override fun onCreate() {
        baseComponent = DaggerBaseComponent.builder()
            .baseModule(BaseModule(application = this)).build()

        networkComponent = DaggerNetworkComponent.create()

        super.onCreate()
    }

    companion object {
        lateinit var baseComponent: BaseComponent
        lateinit var networkComponent: NetworkComponent
    }
}