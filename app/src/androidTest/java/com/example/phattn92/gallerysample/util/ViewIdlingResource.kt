package com.example.phattn92.gallerysample.util

import android.support.test.espresso.IdlingResource
import android.view.View
import java.util.ArrayList

class ViewIdlingResource(private val view: View?) : IdlingResource {
    private var visibility: Int = 0
    private val resourceCallback = ArrayList<IdlingResource.ResourceCallback>()

    override fun getName(): String {
        return "Wait " + view.toString() + " To Idle"
    }

    override fun isIdleNow(): Boolean {
        val isIdle = view != null && view.visibility == visibility

        if (isIdle) {
            for (callback in resourceCallback) {
                callback.onTransitionToIdle()
            }
        }

        return isIdle
    }

    override fun registerIdleTransitionCallback(callback: IdlingResource.ResourceCallback) {
        resourceCallback.add(callback)
    }
}