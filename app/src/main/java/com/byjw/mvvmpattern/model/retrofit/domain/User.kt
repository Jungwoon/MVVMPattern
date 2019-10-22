package com.byjw.mvvmpattern.model.api.domain

import com.byjw.mvvmpattern.model.retrofit.domain.Item
import com.google.gson.annotations.SerializedName

// Reference : https://developer.github.com/v3/users/
data class User(
    @SerializedName("id") val id: Int,
    @SerializedName("login") override val name: String,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("url") override val url: String,
    @SerializedName("type") val type: String
) : Item