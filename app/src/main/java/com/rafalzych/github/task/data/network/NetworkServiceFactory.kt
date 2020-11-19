package com.rafalzych.github.task.data.network

import com.google.gson.GsonBuilder
import com.rafalzych.github.task.util.Constants.BASE_API_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkServiceFactory {

    fun makeRetrofitService(): Retrofit {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(OkHttpClientProvider.provide())
            .baseUrl(BASE_API_URL)
            .build()
    }
}