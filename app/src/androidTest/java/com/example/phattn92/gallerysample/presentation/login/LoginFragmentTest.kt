package com.example.phattn92.gallerysample.presentation.login

import android.content.Intent
import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.phattn92.gallerysample.R
import com.example.phattn92.gallerysample.common.ActivityUtil
import com.example.phattn92.gallerysample.test.SingleFragmentActivity
import com.example.phattn92.gallerysample.util.IdlingResourceViewHelper
import com.nhaarman.mockito_kotlin.verify
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginFragmentTest {

    @get:Rule
    val activityRule = ActivityTestRule(SingleFragmentActivity::class.java,
            true, false)

    lateinit var presenter: LoginContract.Presenter
    lateinit var activityUtil: ActivityUtil

    private val screen = LoginScreen()

    @Test
    fun should_call_presenter_with_correct_username_and_password_value() {
        screen.start()

        screen.apply {
            inputUsername(USERNAME)
            inputPassword(PASSWORD)
            pressLoginButton()
        }

        verify(presenter).login(USERNAME, PASSWORD)
    }

    inner class LoginScreen {
        fun start() {
            activityRule.launchActivity(Intent())
            val fragment = LoginFragment.newInstance() as LoginFragment
            activityRule.activity.setFragment(fragment)
            waitForFragmentAttach()

            presenter = fragment.presenter
            activityUtil = fragment.activityUtil
        }

        fun stop() {
            activityRule.finishActivity()
        }

        private fun waitForFragmentAttach() {
            IdlingResourceViewHelper.waitViewDisplayed(R.id.container_frame)
                    .on(activityRule.activity.findViewById(R.id.container_frame))
        }

        fun pressLoginButton() {
            Espresso.onView(withId(R.id.login_button)).perform(click())
        }

        fun inputUsername(username: String) {
            Espresso.onView(withId(R.id.username_edit_text)).perform(typeText(username))
        }

        fun inputPassword(password: String) {
            Espresso.onView(withId(R.id.password_edit_text)).perform(typeText(password))
        }

        private fun runOnUiThread(runnable: (() -> Unit)) {
            activityRule.runOnUiThread {
                runnable()
            }
        }
    }

    private companion object {
        const val USERNAME = "user-name"
        const val PASSWORD = "password"
    }
}