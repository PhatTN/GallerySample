package com.example.phattn92.gallerysample.external.data

import com.example.phattn92.gallerysample.domain.entity.User
import io.reactivex.Single

interface UserGateway {
    fun login(username: String, password: String) : Single<User>
}