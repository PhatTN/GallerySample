package com.example.phattn92.gallerysample

import android.app.Activity
import android.app.Application
import com.example.phattn92.gallerysample.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

open class GalleryApplication : Application(), HasActivityInjector {

    @Inject lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }

    open fun injectDependencies() {
        AppInjector.init(this)
    }
}