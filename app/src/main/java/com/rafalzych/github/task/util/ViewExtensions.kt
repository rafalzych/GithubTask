package com.rafalzych.github.task.util

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.load.engine.DiskCacheStrategy


fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide(useVisibility: Boolean = false) {
    visibility = if (useVisibility) View.INVISIBLE else View.GONE
}

fun AppCompatImageView.loadImage(imageUrl: String) {
    GlideApp.with(this)
        .load(imageUrl)
        .diskCacheStrategy(DiskCacheStrategy.DATA)
        .fitCenter()
        .into(this)
}