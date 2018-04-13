package com.example.phattn92.gallerysample

import android.app.Application
import android.content.Context
import android.support.test.runner.AndroidJUnitRunner

class TestRunner : AndroidJUnitRunner() {
    override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application {
        return super.newApplication(cl, TestGalleryApplication::class.simpleName, context)
    }
}