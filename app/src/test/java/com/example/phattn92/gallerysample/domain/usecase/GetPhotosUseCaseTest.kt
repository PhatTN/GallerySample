package com.example.phattn92.gallerysample.domain.usecase

import com.example.phattn92.gallerysample.domain.data.AuthorRepository
import com.example.phattn92.gallerysample.domain.data.AuthorRepositoryImpl
import com.example.phattn92.gallerysample.domain.data.PhotoRepository
import com.example.phattn92.gallerysample.domain.data.PhotoRepositoryImpl
import com.example.phattn92.gallerysample.domain.entity.Author
import com.example.phattn92.gallerysample.domain.entity.Photo
import com.example.phattn92.gallerysample.external.data.AuthorGateway
import com.example.phattn92.gallerysample.external.data.PhotoGateway
import com.example.phattn92.gallerysample.testdouble.AuthorGatewayMock
import com.example.phattn92.gallerysample.testdouble.PhotoGatewayMock
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import io.reactivex.Single
import org.junit.Ignore
import org.junit.Test

class GetPhotosUseCaseTest {

    private lateinit var photoGateway: PhotoGateway
    private lateinit var authorGateway: AuthorGateway
    private lateinit var photoRepository: PhotoRepository
    private lateinit var authorRepository: AuthorRepository
    private lateinit var useCase : GetPhotosUseCase

    // There are two styles for writing test
    // #1: Use TestDouble
    @Test
    fun `Should return correct user and author when success_double test version`() {
        setupMock(photo = VALID_PHOTO, author = VALID_AUTHOR)

        useCase.execute()
                .test()
                .assertNoErrors()
                .assertResult(Pair(VALID_PHOTO, VALID_AUTHOR))

        // Verify that method was called
        (authorGateway as AuthorGatewayMock).verifyGetAuthorCalled(VALID_PHOTO.authorId)
    }

    //#2: Use mock tool like Mockito
    @Test
    fun `Should return correct user and author when success_mockito version`() {
        setupMockUsingMockito()

        // Mock
        whenever(photoGateway.getPhotos()).thenReturn(Observable.just(VALID_PHOTO))
        whenever(authorRepository.getAuthorById(VALID_PHOTO.authorId /*use any() if you don't care about passed parameter*/))
                .thenReturn(Single.just(VALID_AUTHOR))

        useCase.execute()
                .test()
                .assertNoErrors()
                .assertResult(Pair(VALID_PHOTO, VALID_AUTHOR))

        // Verify that methods were called
        verify(photoGateway).getPhotos()
        verify(authorGateway).getAuthor(VALID_PHOTO.authorId /* can use any() in here if you don't want to check passed parameter */)
    }

    // This test just for demonstrating.
    // You should pick either TestDouble or Mock Tool style, not both

    // Below tests for you. Should try to write it
    @Test
    @Ignore
    fun `should filter out EmptyPhoto`() {}

    private fun setupMock(photo: Photo? = null, author: Author? = null,
                          throwable: Throwable = Throwable()) {
        photoGateway = PhotoGatewayMock(photo, throwable)
        authorGateway = AuthorGatewayMock(author, throwable)

        photoRepository = PhotoRepositoryImpl(photoGateway)
        authorRepository = AuthorRepositoryImpl(authorGateway)

        useCase = GetPhotosUseCaseImpl(photoRepository, authorRepository)

    }

    private fun setupMockUsingMockito() {
        photoGateway = mock()
        authorGateway = mock()

        photoRepository = PhotoRepositoryImpl(photoGateway)
        authorRepository = AuthorRepositoryImpl(authorGateway)

        useCase = GetPhotosUseCaseImpl(photoRepository, authorRepository)
    }

    companion object {
        private val VALID_PHOTO = Photo.PhotoInfo(1L, "photo-path", 1L, 1)
        private val INVALID_PHOTO = Photo.EmptyPhoto()

        private val VALID_AUTHOR = Author.AuthorInfo(1L, "first-name",
                "last-name", 1L, "VN")
        private val INVALID_AUTHOR = Author.EmptyAuthor()
    }
}