package com.byjw.mvvmpattern.model.di

import com.byjw.mvvmpattern.model.api.SearchApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    // 시작할때 자동으로 생성되지 않게 함 (default: true)
    single(createdAtStart = false) {
        get<Retrofit>().create(SearchApi::class.java)
    }

}