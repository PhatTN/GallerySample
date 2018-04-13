package com.example.phattn92.gallerysample.presentation.gallery

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.phattn92.gallerysample.R
import com.example.phattn92.gallerysample.common.ImageLoader

class PhotoAdapter(private val imageLoader: ImageLoader,
                   private val photoList: MutableList<PhotoViewObject> = mutableListOf())
    : RecyclerView.Adapter<PhotoItemViewHolder>() {

    override fun getItemCount(): Int = photoList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        return PhotoItemViewHolder(view, imageLoader)
    }

    override fun onBindViewHolder(holder: PhotoItemViewHolder, position: Int) {
        holder.bind(photoList[position])
    }

    fun addNewPhotoItem(item: PhotoViewObject) {
        photoList.add(item)
        notifyItemInserted(photoList.size)
    }
}