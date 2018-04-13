package com.example.phattn92.gallerysample.presentation.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.phattn92.gallerysample.R
import com.example.phattn92.gallerysample.common.ActivityUtil
import com.example.phattn92.gallerysample.presentation.gallery.GalleryActivity
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject
import kotlinx.android.synthetic.main.fragment_login.login_button as loginButton
import kotlinx.android.synthetic.main.fragment_login.password_edit_text as passwordEditText
import kotlinx.android.synthetic.main.fragment_login.username_edit_text as usernameEditText

class LoginFragment : Fragment(), LoginContract.View {

    companion object {
        fun newInstance() : Fragment {
            return LoginFragment()
        }
    }

    @Inject lateinit var presenter: LoginContract.Presenter
    @Inject lateinit var activityUtil: ActivityUtil

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (!this::presenter.isInitialized) {
            AndroidSupportInjection.inject(this)
        }

        presenter.attachView(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    override fun openGallery() {
        val intent = Intent(context, GalleryActivity::class.java)
        startActivity(intent)
    }

    override fun showIncorrectUsername() {
        context?.let { activityUtil.showToast(it, "Incorrect username. Please try again") }
    }

    override fun showAccountShouldNotEmpty() {
        context?.let { activityUtil.showToast(it, "Username or password should not empty") }
    }

    override fun showUnknowError() {
        context?.let { activityUtil.showToast(it, "Something is wrong!") }
    }

    private fun initViews() {
        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            presenter.login(username, password)
        }
    }
}
