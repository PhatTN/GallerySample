package com.example.phattn92.gallerysample

import com.example.phattn92.gallerysample.di.AppTestInjector

class TestGalleryApplication : GalleryApplication() {

    override fun injectDependencies() {
        AppTestInjector.init(this)
    }
}