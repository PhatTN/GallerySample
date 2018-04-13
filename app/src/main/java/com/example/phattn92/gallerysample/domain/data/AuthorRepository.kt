package com.example.phattn92.gallerysample.domain.data

import com.example.phattn92.gallerysample.domain.entity.Author
import com.example.phattn92.gallerysample.external.data.AuthorGateway
import io.reactivex.Single

interface AuthorRepository {
    fun getAuthorById(id: Long?) : Single<Author>
}

class AuthorRepositoryImpl(private val authorGateway: AuthorGateway) : AuthorRepository {
    override fun getAuthorById(id: Long?): Single<Author> {
        return authorGateway.getAuthor(id)
    }
}