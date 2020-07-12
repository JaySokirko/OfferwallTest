package com.jay.offerwalltest.di.network

import com.jay.offerwalltest.annotation.RecordById
import com.jay.offerwalltest.annotation.RecordList
import com.jay.offerwalltest.api.OfferwallTestApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @RecordList
    @Provides
    fun provideResponseA(): OfferwallTestApi {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(OfferwallTestApi.BASE_URL)
            .build()
            .create(OfferwallTestApi::class.java)
    }

    @RecordById
    @Provides
    fun provideResponseB(): OfferwallTestApi {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(OfferwallTestApi.BASE_URL)
            .build()
            .create(OfferwallTestApi::class.java)
    }
}