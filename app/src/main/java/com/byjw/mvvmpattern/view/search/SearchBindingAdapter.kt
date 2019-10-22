package com.byjw.mvvmpattern.view.search

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.byjw.mvvmpattern.model.api.domain.Repository
import com.byjw.mvvmpattern.model.api.domain.User
import com.byjw.mvvmpattern.model.api.response.RepositoriesResponse
import com.byjw.mvvmpattern.model.retrofit.domain.Item
import com.byjw.mvvmpattern.viewModel.SearchViewModel

@BindingAdapter(value = ["items", "viewModel"])
fun setItems(view: RecyclerView, items: List<Item>, viewModel: SearchViewModel) {
    view.adapter?.run {
        if (this is SearchAdapter) {
            this.itemList = items
            this.notifyDataSetChanged()
        }
    } ?: run {
        SearchAdapter(items, viewModel).apply { view.adapter = this }
    }
}

@BindingAdapter("setImageUrl")
fun setAvatarImage(imageView: ImageView, item: Item) {
    val imageUrl = when (item) {
        is User -> item.avatarUrl
        is Repository -> item.owner.avatarUrl
        else -> null
    }

    Glide.with(imageView).load(imageUrl).apply(RequestOptions.circleCropTransform()).into(imageView)
}