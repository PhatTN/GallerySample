package com.example.phattn92.gallerysample.presentation.gallery

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.example.phattn92.gallerysample.R
import com.example.phattn92.gallerysample.common.ActivityUtil
import com.example.phattn92.gallerysample.common.ImageLoader
import com.example.phattn92.gallerysample.di.Injectable
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_main.gallery_recycler_view as galleryRecyclerView

class GalleryActivity : AppCompatActivity(), GalleryContract.View, Injectable {

    @Inject lateinit var presenter: GalleryContract.Presenter
    @Inject lateinit var activityUtil: ActivityUtil
    @Inject lateinit var imageLoader: ImageLoader

    private lateinit var photoAdapter: PhotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initData()
    }

    override fun showPhotoToPhotoList(photo: PhotoViewObject) {
        photoAdapter.addNewPhotoItem(photo)
    }

    override fun showLoadingPhotoCompletedMessage() {
        activityUtil.showToast(this, "Load photo completed")
    }

    private fun initViews() {
        presenter.attachView(this)

        photoAdapter = PhotoAdapter(imageLoader)
        galleryRecyclerView.adapter = photoAdapter
        galleryRecyclerView.layoutManager = GridLayoutManager(this, 2)
        galleryRecyclerView.setHasFixedSize(true)
    }

    private fun initData() {
        presenter.getPhotos()
    }
}
