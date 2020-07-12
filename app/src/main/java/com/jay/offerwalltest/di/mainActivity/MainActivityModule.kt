package com.jay.offerwalltest.di.mainActivity

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.jay.offerwalltest.ui.activity.MainActivityViewModel
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    companion object {
        @Provides
        fun provideMainActivityVM(activity: FragmentActivity): MainActivityViewModel {
            return ViewModelProviders.of(activity).get(MainActivityViewModel::class.java)
        }
    }
}