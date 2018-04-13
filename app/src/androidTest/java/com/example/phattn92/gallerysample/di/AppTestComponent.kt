package com.example.phattn92.gallerysample.di

import android.app.Application
import com.example.phattn92.gallerysample.TestGalleryApplication
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * In here, you should run <i>assembleAndroidTest</i> gradle task before using
 * to generate code. Sorry, I have not enough time to config in gradle.
 * You can search how to config it. That is a exercise for you :D
 */
@Singleton
@Component(modules = [(FakeAppModule::class), (ActivityModule::class)])
interface AppTestComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application) : Builder
        fun build() : AppTestComponent
    }

    fun inject(application: TestGalleryApplication)
}