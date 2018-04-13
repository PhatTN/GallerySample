package com.example.phattn92.gallerysample.test

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import android.widget.FrameLayout
import com.example.phattn92.gallerysample.R
import com.example.phattn92.gallerysample.di.Injectable
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class SingleFragmentActivity : AppCompatActivity(), Injectable, HasSupportFragmentInjector {

    @Inject lateinit var dispatchingAndroidInjector : DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val container = FrameLayout(this)
        container.layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT)
        container.id = R.id.container_frame
        setContentView(container)
    }

    fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container_frame, fragment)
                .commit()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    }
}