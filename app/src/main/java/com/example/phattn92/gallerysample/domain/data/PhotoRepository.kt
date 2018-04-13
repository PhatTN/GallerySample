package com.example.phattn92.gallerysample.domain.data

import com.example.phattn92.gallerysample.domain.entity.Photo
import com.example.phattn92.gallerysample.external.data.PhotoGateway
import io.reactivex.Observable

interface PhotoRepository {
    fun getPhotos() : Observable<Photo>
}

class PhotoRepositoryImpl(private val photoGateway: PhotoGateway) : PhotoRepository {
    override fun getPhotos(): Observable<Photo> {
        return photoGateway.getPhotos()
    }
}