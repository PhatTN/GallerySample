package com.example.phattn92.gallerysample.domain.usecase

import com.example.phattn92.gallerysample.domain.data.AuthorRepository
import com.example.phattn92.gallerysample.domain.data.PhotoRepository
import com.example.phattn92.gallerysample.domain.entity.Author
import com.example.phattn92.gallerysample.domain.entity.Photo
import io.reactivex.Observable

interface GetPhotosUseCase {
    fun execute() : Observable<Pair<Photo.PhotoInfo, Author>>
}

class GetPhotosUseCaseImpl(private val photoRepository: PhotoRepository,
                           private val authorRepository: AuthorRepository) : GetPhotosUseCase {
    private companion object {
        private const val MAX_CONCURRENT = 5
    }

    override fun execute(): Observable<Pair<Photo.PhotoInfo, Author>> {
        // In here, actually we don't need author for each photo
        // But I want to make it complicated for demonstrating purpose :D
        return photoRepository.getPhotos()
                .filter { it !is Photo.EmptyPhoto }
                .cast(Photo.PhotoInfo::class.java)
                .flatMap({
                    authorRepository
                            .getAuthorById(it.authorId)
                            .toObservable()
                }, { photo, author ->
                    Pair(photo, author)
                }, MAX_CONCURRENT)
    }
}