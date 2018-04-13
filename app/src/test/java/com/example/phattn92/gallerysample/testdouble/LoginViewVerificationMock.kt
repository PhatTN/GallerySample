package com.example.phattn92.gallerysample.testdouble

import com.example.phattn92.gallerysample.presentation.login.LoginContract

class LoginViewVerificationMock : LoginContract.View {

    private var openGalleryCalled = false
    private var showIncorrectUsernameCalled = false
    private var showAccountShouldNotEmptyCalled = false
    private var showUnknownErrorCalled = false

    override fun openGallery() {
        openGalleryCalled = true
    }

    override fun showIncorrectUsername() {
        showIncorrectUsernameCalled = true
    }

    override fun showAccountShouldNotEmpty() {
        showAccountShouldNotEmptyCalled = true
    }

    override fun showUnknownError() {
        showUnknownErrorCalled = true
    }

    fun verifyOpenGalleryCalled() = openGalleryCalled

    fun verifyShowIncorrectUsername() = showIncorrectUsernameCalled

    fun verifyShowAccountShouldNotEmpty() = showAccountShouldNotEmptyCalled

    fun verifyShowUnknownErrorCalled() = showUnknownErrorCalled
}