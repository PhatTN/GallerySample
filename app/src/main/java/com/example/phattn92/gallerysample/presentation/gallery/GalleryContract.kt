package com.example.phattn92.gallerysample.presentation.gallery

import com.example.phattn92.gallerysample.base.BasePresenter

interface GalleryContract {
    interface View {
        fun showPhotoToPhotoList(photo: PhotoViewObject)
        fun showLoadingPhotoCompletedMessage()
    }

    interface Presenter : BasePresenter<View> {
        fun getPhotos()
    }
}