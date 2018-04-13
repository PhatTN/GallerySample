package com.example.phattn92.gallerysample.domain.data

import com.example.phattn92.gallerysample.domain.entity.User
import com.example.phattn92.gallerysample.external.data.UserGateway
import io.reactivex.Single

interface UserRepository {
    fun login(username: String, password: String) : Single<User>
}

class UserRepositoryImpl(private val userGateway: UserGateway) : UserRepository {
    override fun login(username: String, password: String): Single<User> {
        return userGateway.login(username, password)
    }
}