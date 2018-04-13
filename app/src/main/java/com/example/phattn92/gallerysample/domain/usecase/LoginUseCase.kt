package com.example.phattn92.gallerysample.domain.usecase

import android.support.annotation.VisibleForTesting
import com.example.phattn92.gallerysample.domain.data.UserRepository
import com.example.phattn92.gallerysample.domain.entity.User
import io.reactivex.Single

interface LoginUseCase {
    fun execute(username: String, password: String) : Single<User>
}

class LoginUseCaseImpl(private val userRepository: UserRepository) : LoginUseCase {

    @VisibleForTesting
    var accountInfoValidator : AccountInfoValidator = AccountInfoValidatorImpl()

    override fun execute(username: String, password: String): Single<User> {
        return Single.just(Pair(username, password))
                .doOnSuccess { (usrname, pws) ->
                    if (accountInfoValidator.isValid(usrname, pws)) {
                        throw IllegalArgumentException()
                    }
                }
                .flatMap{ (usrname, pws) ->
                    userRepository.login(usrname, pws)
                }
    }
}