package com.example.phattn92.gallerysample.presentation.gallery

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.example.phattn92.gallerysample.common.ImageLoader
import kotlinx.android.synthetic.main.item_photo.view.photo_imageView as photoViewImage

class PhotoItemViewHolder(view: View, private val imageLoader: ImageLoader)
    : RecyclerView.ViewHolder(view) {

    fun bind(photo: PhotoViewObject) {
        imageLoader.load(itemView.context, photo.path, itemView.photoViewImage)
    }
}