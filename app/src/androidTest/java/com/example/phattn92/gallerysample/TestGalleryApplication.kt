package com.example.phattn92.gallerysample

import com.example.phattn92.gallerysample.di.DaggerAppTestComponent

class TestGalleryApplication : GalleryApplication() {

    override fun injectDependencies() {
        DaggerAppTestComponent.builder()
                .application(this)
                .build()
    }
}