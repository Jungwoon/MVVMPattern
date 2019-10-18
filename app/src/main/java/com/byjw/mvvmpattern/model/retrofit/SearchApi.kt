package com.byjw.mvvmpattern.model.api

import com.byjw.mvvmpattern.model.api.response.RepositoriesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface SearchApi {

    @GET("/search/repositories")
    fun search(@QueryMap params: MutableMap<String, String>): Single<RepositoriesResponse>

}