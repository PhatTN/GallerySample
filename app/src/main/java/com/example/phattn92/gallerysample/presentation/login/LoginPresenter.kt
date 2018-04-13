package com.example.phattn92.gallerysample.presentation.login

import com.example.phattn92.gallerysample.domain.usecase.LoginUseCase
import com.example.phattn92.gallerysample.external.data.AuthenticationFailureException
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LoginPresenter(private val loginUseCase: LoginUseCase,
                     private val scheduler: Scheduler = Schedulers.io(),
                     private val uiScheduler: Scheduler = AndroidSchedulers.mainThread())
    : LoginContract.Presenter {

    private lateinit var view : LoginContract.View
    private val disposables : CompositeDisposable = CompositeDisposable()

    override fun attachView(view: LoginContract.View) {
        this.view = view
    }

    override fun detachView() {
        disposables.dispose()
    }

    override fun login(username: String, password: String) {
        loginUseCase.execute(username, password)
                .subscribeOn(scheduler)
                .observeOn(uiScheduler)
                .subscribe({
                    view.openGallery()
                }, { throwable ->
                    when (throwable) {
                        is IllegalArgumentException -> view.showAccountShouldNotEmpty()
                        is AuthenticationFailureException -> view.showIncorrectUsername()
                        else -> view.showUnknowError()
                    }
                })
                .let { disposables.add(it) }
    }
}