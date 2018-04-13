package com.example.phattn92.gallerysample.common

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.squareup.picasso.Picasso

interface ImageLoader {
   fun load(context: Context, imagePath: String, imageView: ImageView)
}

class PicassoImageLoader : ImageLoader {

   override fun load(context: Context, imagePath: String, imageView: ImageView) {
       Picasso.get().load(imagePath).into(imageView)
   }
}

class GlideImageLoader : ImageLoader {
    override fun load(context: Context, imagePath: String, imageView: ImageView) {
        Glide.with(context).load(imagePath).into(imageView)
    }
}