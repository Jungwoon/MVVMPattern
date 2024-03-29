package com.byjw.mvvmpattern.model.api.response

import com.byjw.mvvmpattern.model.api.domain.Repository
import com.google.gson.annotations.SerializedName

// Reference : https://developer.github.com/v3/repos/
data class RepositoriesResponse(
    @SerializedName("total_count") val totalCount: Int,
    @SerializedName("incomplete_results") val incompleteResults: Boolean,
    @SerializedName("items") val repositories: ArrayList<Repository>
)
