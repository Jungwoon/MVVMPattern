package com.byjw.mvvmpattern.model.api

import com.byjw.mvvmpattern.model.api.response.RepositoriesResponse
import com.byjw.mvvmpattern.model.api.response.UsersResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface SearchApi {

    @GET("/search/repositories")
    fun searchRepository(@QueryMap params: MutableMap<String, String>): Single<RepositoriesResponse>

    @GET("/search/users")
    fun searchUser(@QueryMap params: MutableMap<String, String>): Single<UsersResponse>

}