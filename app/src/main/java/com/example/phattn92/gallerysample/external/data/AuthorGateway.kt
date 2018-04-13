package com.example.phattn92.gallerysample.external.data

import com.example.phattn92.gallerysample.domain.entity.Author
import io.reactivex.Single

interface AuthorGateway {
    fun getAuthor(id: Long?) : Single<Author>
}