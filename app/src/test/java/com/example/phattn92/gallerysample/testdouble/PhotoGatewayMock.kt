package com.example.phattn92.gallerysample.testdouble

import com.example.phattn92.gallerysample.domain.entity.Photo
import com.example.phattn92.gallerysample.external.data.PhotoGateway
import io.reactivex.Observable

/**
 * Mock for testing purpose
 * If there are too many arguments, should consider to create builder
 */
class PhotoGatewayMock(private val photo: Photo? = null,
                       private val exception: Throwable = Throwable()) : PhotoGateway {

    override fun getPhotos(): Observable<Photo> {
        if (photo == null) {
            return Observable.error<Photo>(exception)
        }

        return Observable.just(photo)
    }

    override fun getFavoritePhotos(): Observable<Photo> {
        // Handle same thing here
        return Observable.empty()
    }
}