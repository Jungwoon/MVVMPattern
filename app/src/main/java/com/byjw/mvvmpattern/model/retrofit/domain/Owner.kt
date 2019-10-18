package com.byjw.mvvmpattern.model.api.domain

import com.google.gson.annotations.SerializedName

// Reference : https://developer.github.com/v3/users/
data class Owner(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("url") val url: String,
    @SerializedName("type") val type: String
)