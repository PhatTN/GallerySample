package com.example.phattn92.gallerysample.base

interface BasePresenter<in T> {
    fun attachView(view: T)
    fun detachView()
}