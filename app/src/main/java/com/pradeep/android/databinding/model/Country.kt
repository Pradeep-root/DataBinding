package com.pradeep.android.databinding.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

data class Country(
    val name : String = "",
    val flag : String = "",
    val capital : String = "",
    val population : String = ""
)

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String?){
    Picasso.get().load(url).into(imageView)
}