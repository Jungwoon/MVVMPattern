package com.byjw.mvvmpattern.view.search

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.byjw.mvvmpattern.model.api.domain.Repository
import com.byjw.mvvmpattern.viewModel.SearchViewModel

@BindingAdapter(value = ["repositories", "viewModel"])
fun setRepositories(view: RecyclerView, items: List<Repository>, vm: SearchViewModel) {
    view.adapter?.run {
        if (this is SearchAdapter) {
            this.repositoryList = items
            this.notifyDataSetChanged()
        }
    } ?: run {
        SearchAdapter(items, vm).apply { view.adapter = this }
    }
}

@BindingAdapter("setImageUrl")
fun setAvatarImage(imageView: ImageView, imageUrl: String) {
    Glide.with(imageView).load(imageUrl).apply(RequestOptions.circleCropTransform()).into(imageView)
}