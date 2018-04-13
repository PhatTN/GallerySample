package com.example.phattn92.gallerysample.presentation.login

import com.example.phattn92.gallerysample.base.BasePresenter

interface LoginContract {
    interface View {
        fun openGallery()
        fun showIncorrectUsername()
        fun showAccountShouldNotEmpty()
        fun showUnknownError()
    }

    interface Presenter : BasePresenter<View> {
        fun login(username: String, password: String)
    }
}