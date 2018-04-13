package com.example.phattn92.gallerysample.domain.entity

sealed class Author {

    class AuthorInfo(val id: Long, val firstName: String, val lastName: String,
                     val birhDate: Long, val countryCode: String)  : Author()

    class EmptyAuthor() : Author()
}