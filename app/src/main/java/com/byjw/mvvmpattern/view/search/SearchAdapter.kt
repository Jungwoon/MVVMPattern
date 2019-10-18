package com.byjw.mvvmpattern.view.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.byjw.mvvmpattern.R
import com.byjw.mvvmpattern.model.api.domain.Repository
import com.byjw.mvvmpattern.viewModel.SearchViewModel

class SearchAdapter(
    var repositoryList: List<Repository> = arrayListOf(),
    private val searchViewModel: SearchViewModel
) : RecyclerView.Adapter<SearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SearchViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_repository,
            parent,
            false
        )
    )

    override fun getItemCount() = repositoryList.size

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.binding.repository = repositoryList[position]
        holder.binding.viewModel = searchViewModel
    }

}