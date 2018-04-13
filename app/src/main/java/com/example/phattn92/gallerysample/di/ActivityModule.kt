package com.example.phattn92.gallerysample.di

import com.example.phattn92.gallerysample.presentation.gallery.GalleryActivity
import com.example.phattn92.gallerysample.presentation.login.LoginActivity
import com.example.phattn92.gallerysample.presentation.login.LoginFragment
import com.example.phattn92.gallerysample.test.SingleFragmentActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeGalleryActivity() : GalleryActivity

    @ContributesAndroidInjector
    abstract fun contributeLoginActivity() : LoginActivity

    @ContributesAndroidInjector
    abstract fun contributeLoginFragment() : LoginFragment

    @ContributesAndroidInjector
    abstract fun contributeSingleFragmentActivity() : SingleFragmentActivity
}