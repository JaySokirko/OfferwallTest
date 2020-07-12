package com.jay.offerwalltest.api

import com.jay.offerwalltest.BaseApplication
import com.jay.offerwalltest.model.record.RequestB
import com.jay.offerwalltest.model.record.RequestA
import io.reactivex.Observable

class OfferwallNetworkRequest {

    private val recordList: OfferwallTestApi = BaseApplication.networkComponent.recordList
    private val recordById: OfferwallTestApi = BaseApplication.networkComponent.recordById

    fun getResponseA(): Observable<List<RequestA>> {
        return recordList.getResponseA()
    }

    fun getResponseB(id: Int): Observable<RequestB> {
       return recordById.getResponseB(id)
    }
}