package com.example.phattn92.gallerysample.external.data

import com.example.phattn92.gallerysample.domain.entity.Photo
import io.reactivex.Observable
import io.reactivex.Single

interface PhotoGateway {
    fun getPhotos() : Observable<Photo>
    fun getFavoritePhotos() : Observable<Photo>
}