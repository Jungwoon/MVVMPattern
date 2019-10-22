package com.byjw.mvvmpattern.view.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.byjw.mvvmpattern.R
import com.byjw.mvvmpattern.model.retrofit.domain.Item
import com.byjw.mvvmpattern.viewModel.SearchViewModel

class SearchAdapter(
    var itemList: List<Item> = arrayListOf(),
    private val searchViewModel: SearchViewModel
) : RecyclerView.Adapter<SearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SearchViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_cardview,
            parent,
            false
        )
    )

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.binding.item = itemList[position]
        holder.binding.viewModel = searchViewModel
    }

}