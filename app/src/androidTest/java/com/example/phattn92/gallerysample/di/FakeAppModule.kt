package com.example.phattn92.gallerysample.di

import com.example.phattn92.gallerysample.common.ActivityUtil
import com.example.phattn92.gallerysample.common.ImageLoader
import com.example.phattn92.gallerysample.presentation.gallery.GalleryContract
import com.example.phattn92.gallerysample.presentation.login.LoginContract
import com.nhaarman.mockito_kotlin.mock
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FakeAppModule {

    @Singleton
    @Provides
    fun provideImageLoader() : ImageLoader = mock()

    @Singleton
    @Provides
    fun provideActivityUtil() : ActivityUtil = mock()

    @Singleton
    @Provides
    fun provideLoginPresenter() : LoginContract.Presenter = mock()

    @Singleton
    @Provides
    fun provideGalleryPresenter() : GalleryContract.Presenter = mock()

}