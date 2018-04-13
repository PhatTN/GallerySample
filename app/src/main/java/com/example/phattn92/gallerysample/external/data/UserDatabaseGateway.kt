package com.example.phattn92.gallerysample.external.data

import com.example.phattn92.gallerysample.domain.entity.User
import io.reactivex.Single

class UserDatabaseGateway : UserGateway {
    override fun login(username: String, password: String): Single<User> {
        return Single.create { source ->
            // Simulate I/O delay
            Thread.sleep(2000)

            if (username != password) {
                source.onError(AuthenticationFailureException())
            }

            val user = User(1L, username)
            source.onSuccess(user)
        }
    }
}

class AuthenticationFailureException : Throwable()