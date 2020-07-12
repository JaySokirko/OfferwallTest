package com.jay.offerwalltest.api

import com.jay.offerwalltest.model.record.RequestA
import com.jay.offerwalltest.model.record.RequestB
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface OfferwallTestApi {

    @GET("/api/v1/trending")
    fun getResponseA(): Observable<List<RequestA>>

    @GET("/api/v1/object/{id}")
    fun getResponseB(@Path("id") id: Int): Observable<RequestB>

    companion object {
        const val BASE_URL = "https://demo0040494.mockable.io"
    }
}