package com.yasunov.myapplication.domain

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun loadImage(
    url: String?,
    imageView: ImageView
) {
    Picasso.get().load(url).into(imageView)
}
