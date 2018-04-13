package com.example.phattn92.gallerysample.presentation.gallery

import com.example.phattn92.gallerysample.domain.usecase.GetPhotosUseCase
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class GalleryPresenter(private val getPhotosUseCase: GetPhotosUseCase,
                       private val scheduler: Scheduler = Schedulers.io(),
                       private val uiScheduler: Scheduler = AndroidSchedulers.mainThread())
    : GalleryContract.Presenter {

    private lateinit var view : GalleryContract.View
    private val disposables : CompositeDisposable = CompositeDisposable()

    override fun attachView(view: GalleryContract.View) {
        this.view = view
    }

    override fun detachView() {
        disposables.dispose()
    }

    override fun getPhotos() {
        getPhotosUseCase.execute()
                .subscribeOn(scheduler)
                .map { PhotoViewObject(it.first.path) }
                .observeOn(uiScheduler)
                .subscribe({
                    view.showPhotoToPhotoList(it)
                }, {
                    it.printStackTrace()
                }, {
                    view.showLoadingPhotoCompletedMessage()
                })
                .let { disposables.add(it) }
    }
}