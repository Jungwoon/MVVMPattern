package com.byjw.mvvmpattern.model.api.domain

import com.byjw.mvvmpattern.model.retrofit.domain.Item
import com.google.gson.annotations.SerializedName

// Reference : https://developer.github.com/v3/repos/
data class Repository(
    @SerializedName("id") val id: Long,
    @SerializedName("name") override val name: String,
    @SerializedName("owner") val owner: User,
    @SerializedName("description") val description: String?,
    @SerializedName("fork") val fork: Boolean,
    @SerializedName("url") override val url: String,
    @SerializedName("stargazers_count") val stargazersCount: Int,
    @SerializedName("watchers_count") val watchersCount: Int,
    @SerializedName("language") val language: String?,
    @SerializedName("forks_count") val forksCount: Int,
    @SerializedName("open_issues_count") val openIssuesCount: Int,
    @SerializedName("master_branch") val masterBranch: String,
    @SerializedName("default_branch") val defaultBranch: String,
    @SerializedName("score") val score: Double
) : Item
