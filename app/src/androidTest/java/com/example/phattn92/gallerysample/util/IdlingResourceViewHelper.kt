package com.example.phattn92.gallerysample.util

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.UiController
import android.support.test.espresso.ViewAction
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.view.View
import org.hamcrest.Matcher

class IdlingResourceViewHelper private constructor(private val resId: Int) {

    fun on(view: View): ViewIdlingResource {
        val idlingResource = ViewIdlingResource(view)

        onView(withId(resId)).perform(object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return ViewMatchers.isAssignableFrom(View::class.java)
            }

            override fun getDescription(): String {
                return "Registering Idling Resources"
            }

            override fun perform(uiController: UiController, view: View) {
                Espresso.registerIdlingResources(idlingResource)
                try {
                    uiController.loopMainThreadUntilIdle()
                } finally {
                    Espresso.unregisterIdlingResources(idlingResource)
                }
            }
        })

        return idlingResource
    }

    companion object {

        fun waitViewDisplayed(resId: Int): IdlingResourceViewHelper {
            return IdlingResourceViewHelper(resId)
        }
    }
}