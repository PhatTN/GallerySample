package com.example.phattn92.gallerysample.presentation.login

import android.content.Intent
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import org.junit.Rule
import org.mockito.InjectMocks

class LoginActivityTest {

    @Rule
    val activityRule = ActivityTestRule<LoginActivity>(LoginActivity::class.java,
            true, false)

    inner class LoginScreen {
        fun start() {
            activityRule.launchActivity(Intent())
        }

        fun stop() {
            activityRule.finishActivity()
        }

        fun pressLoginButton() {
            onView(withId())
        }

        private fun runOnUiThread(runnable: (() -> Unit)) {
            activityRule.runOnUiThread {
                runnable()
            }
        }
    }
}