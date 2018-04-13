package com.example.phattn92.gallerysample.presentation.login

import com.example.phattn92.gallerysample.domain.entity.User
import com.example.phattn92.gallerysample.testdouble.LoginUseCaseMock
import com.example.phattn92.gallerysample.testdouble.LoginViewVerificationMock
import io.reactivex.schedulers.Schedulers
import org.junit.Test

class LoginPresenterTest {

    private lateinit var presenter : LoginContract.Presenter
    private lateinit var view : LoginViewVerificationMock
    private lateinit var loginUseCase: LoginUseCaseMock

    @Test
    fun `should open gallery when login successfully`() {
        setupMock(USER)

        presenter.login(USERNAME, PASSWORD)

        loginUseCase.verifyExecuteCalled(USERNAME, PASSWORD)
        view.verifyOpenGalleryCalled()
    }

    private fun setupMock(user: User? = null, throwable: Throwable = Throwable()) {
        loginUseCase = LoginUseCaseMock(user, throwable)
        presenter = LoginPresenter(loginUseCase, Schedulers.trampoline(), Schedulers.trampoline())
        view = LoginViewVerificationMock()

        presenter.attachView(view)
    }

    private companion object {
        val USER = User(1L, "user-name")
        const val USERNAME = "user-name"
        const val PASSWORD = "password"
    }
}