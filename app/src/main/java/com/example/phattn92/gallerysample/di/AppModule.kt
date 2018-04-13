package com.example.phattn92.gallerysample.di

import com.example.phattn92.gallerysample.common.ActivityUtil
import com.example.phattn92.gallerysample.common.ActivityUtilImpl
import com.example.phattn92.gallerysample.common.GlideImageLoader
import com.example.phattn92.gallerysample.common.ImageLoader
import com.example.phattn92.gallerysample.domain.data.*
import com.example.phattn92.gallerysample.domain.usecase.GetPhotosUseCase
import com.example.phattn92.gallerysample.domain.usecase.GetPhotosUseCaseImpl
import com.example.phattn92.gallerysample.domain.usecase.LoginUseCase
import com.example.phattn92.gallerysample.domain.usecase.LoginUseCaseImpl
import com.example.phattn92.gallerysample.external.data.*
import com.example.phattn92.gallerysample.presentation.gallery.GalleryContract
import com.example.phattn92.gallerysample.presentation.gallery.GalleryPresenter
import com.example.phattn92.gallerysample.presentation.login.LoginContract
import com.example.phattn92.gallerysample.presentation.login.LoginPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideImageLoader() : ImageLoader = GlideImageLoader()

    @Singleton
    @Provides
    fun provideActivityUtil() : ActivityUtil = ActivityUtilImpl()

    @Singleton
    @Provides
    fun providePhotoGateway() : PhotoGateway = PhotoNetworkGateway()

    @Singleton
    @Provides
    fun provideAuthorGateway() : AuthorGateway = AuthorNetworkGateway()

    @Singleton
    @Provides
    fun providePhotoRepository(photoGateway: PhotoGateway) : PhotoRepository
            = PhotoRepositoryImpl(photoGateway)

    @Singleton
    @Provides
    fun provideAuthorRepository(authorGateway: AuthorGateway) : AuthorRepository
            = AuthorRepositoryImpl(authorGateway)

    @Singleton
    @Provides
    fun provideGetPhotosUseCase(photoRepository: PhotoRepository, authorRepository: AuthorRepository)
            : GetPhotosUseCase = GetPhotosUseCaseImpl(photoRepository, authorRepository)

    @Singleton
    @Provides
    fun provideGalleryPresenter(getPhotosUseCase: GetPhotosUseCase) : GalleryContract.Presenter
            = GalleryPresenter(getPhotosUseCase)

    @Singleton
    @Provides
    fun provideUserGateway() : UserGateway = UserDatabaseGateway()

    @Singleton
    @Provides
    fun provideUserRepository(userGateway: UserGateway) : UserRepository = UserRepositoryImpl(userGateway)

    @Singleton
    @Provides
    fun provideLoginUseCase(userRepository: UserRepository) : LoginUseCase = LoginUseCaseImpl(userRepository)

    @Singleton
    @Provides
    fun provideLoginPresenter(loginUseCase: LoginUseCase) : LoginContract.Presenter
            = LoginPresenter(loginUseCase)
}