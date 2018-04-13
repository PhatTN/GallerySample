package com.example.phattn92.gallerysample.external.data

import com.example.phattn92.gallerysample.domain.entity.Photo
import io.reactivex.Observable
import java.util.*

class PhotoNetworkGateway : PhotoGateway {

    private companion object {
        const val MAX_RANDOM_NUM = 1000
        const val MIN_RANDOM_NUM = 0
    }

    override fun getPhotos(): Observable<Photo> {
        return Observable.create { source ->

            // will return 100 results before completed
            (0..100).forEach {
                val photo = try {
                    queryPhoto()
                } catch (error: Throwable) {
                    Photo.EmptyPhoto()
                }

                source.onNext(photo)
            }

            source.onComplete()
        }
    }

    override fun getFavoritePhotos(): Observable<Photo> {
        // Implement getting favorite photos here
        return Observable.empty()
    }

    private fun queryPhoto() : Photo {
        // Simulate network delay
        Thread.sleep(100)

        val randNum = generateRandNum()

        // Simulate network error
        if (randNum % 10 == 0) {
            throw Throwable("Photo not found. Code = 404")
        }

        return Photo.PhotoInfo(randNum.toLong(),
                "https://picsum.photos/300/300/?image=$randNum",
                randNum.toLong(),
                Date().time)
    }

    private fun generateRandNum() : Int {
        return Random().nextInt(MAX_RANDOM_NUM - MIN_RANDOM_NUM) + MIN_RANDOM_NUM
    }
}