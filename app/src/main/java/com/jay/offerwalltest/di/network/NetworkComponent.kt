package com.jay.offerwalltest.di.network

import com.jay.offerwalltest.annotation.RecordById
import com.jay.offerwalltest.annotation.RecordList
import com.jay.offerwalltest.api.OfferwallTestApi
import dagger.Component

@Component(modules = [NetworkModule::class])
interface NetworkComponent {

    @get:RecordList
    val recordList: OfferwallTestApi

    @get:RecordById
    val recordById: OfferwallTestApi

}