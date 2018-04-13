package com.example.phattn92.gallerysample.domain.usecase

interface AccountInfoValidator {
    fun isValid(username: String, password: String) : Boolean
}

class AccountInfoValidatorImpl : AccountInfoValidator {
    override fun isValid(username: String, password: String): Boolean {
        return username.isEmpty() || password.isEmpty()
    }
}