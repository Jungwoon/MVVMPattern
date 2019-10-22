package com.byjw.mvvmpattern.model.api.response

import com.byjw.mvvmpattern.model.api.domain.User
import com.google.gson.annotations.SerializedName

// Reference : https://developer.github.com/v3/users/
data class UsersResponse(
    @SerializedName("total_count") val totalCount: Int,
    @SerializedName("incomplete_results") val incompleteResults: Boolean,
    @SerializedName("items") val users: ArrayList<User>
)
