package com.example.phattn92.gallerysample.testdouble

import com.example.phattn92.gallerysample.domain.entity.User
import com.example.phattn92.gallerysample.domain.usecase.LoginUseCase
import io.reactivex.Single

class LoginUseCaseMock(private val user: User? = null,
                       private val throwable: Throwable = Throwable()) : LoginUseCase {

    private var executeCalled = false
    private var username: String? = null
    private var password: String? = null

    override fun execute(username: String, password: String): Single<User> {
        executeCalled = true
        this.username = username
        this.password = password

        if (user == null) {
            return Single.error(throwable)
        }

        return Single.just(user)
    }

    fun verifyExecuteCalled(username: String, password: String) : Boolean {
        return executeCalled && this.username == username && this.password == password
    }
}