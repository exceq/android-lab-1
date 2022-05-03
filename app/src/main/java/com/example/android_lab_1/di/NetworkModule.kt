package com.example.android_lab_1.di

import com.example.android_lab_1.domain.api.MockApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
class NetworkModule {

    @Provides
    fun provideMockService(): MockApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://61f5894b62f1e300173c41ba.mockapi.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create()
    }
}
