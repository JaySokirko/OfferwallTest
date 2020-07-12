package com.jay.offerwalltest.di.mainActivity

import androidx.fragment.app.FragmentActivity
import com.jay.offerwalltest.ui.activity.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [MainActivityModule::class])
interface MainActivityComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: FragmentActivity) : Builder
        fun build(): MainActivityComponent
    }

    fun inject(activity: MainActivity)
}