package com.byjw.mvvmpattern.model.di

import com.byjw.mvvmpattern.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    single { Cache(androidApplication().cacheDir, 10L * 1024 * 1024) }

    single { GsonBuilder().create() }

    single {
        Interceptor {
            it.proceed(it.request().newBuilder().apply {
                header("Accept", "application/vnd.github.mercy-preview+json")
            }.build())
        }
    }

    single {
        OkHttpClient.Builder().apply {
            cache(get())
            connectTimeout(15L, TimeUnit.SECONDS)
            writeTimeout(15L, TimeUnit.SECONDS)
            readTimeout(15L, TimeUnit.SECONDS)
            retryOnConnectionFailure(true)
            addInterceptor(get()) // 위에서 만든 Interceptor 가져오기
            addInterceptor(HttpLoggingInterceptor().apply {
                if (BuildConfig.DEBUG)
                    level = HttpLoggingInterceptor.Level.BODY
            })
        }.build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create(get()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(get()) // 위에서 만든 OkHttpClient 가져오기
            .build()
    }

}