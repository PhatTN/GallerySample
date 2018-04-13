package com.example.phattn92.gallerysample.common

import android.content.Context
import android.widget.Toast

interface ActivityUtil {
    fun showToast(context: Context, text: String)
}

class ActivityUtilImpl : ActivityUtil {
    override fun showToast(context: Context, text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }
}