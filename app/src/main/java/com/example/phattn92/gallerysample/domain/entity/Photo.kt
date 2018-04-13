package com.example.phattn92.gallerysample.domain.entity

sealed class Photo{

    data class PhotoInfo(val id: Long, val path: String, val authorId: Long?,
                         val createdDate: Long) : Photo()

    class EmptyPhoto : Photo()
}

