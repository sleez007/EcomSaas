package com.novacore.ecomsaas.bindings

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.novacore.ecomsaas.R

@BindingAdapter("fullImgPath")
fun ImageView.setImageSource(path : String ){
    try {
        val options = RequestOptions()
        Glide.with(context).load(path).apply(options.placeholder(R.drawable.loading_placeholder).error(R.drawable.loading_placeholder)).into(this)
    }catch (ex: Exception){
        println(ex.message)
    }

}