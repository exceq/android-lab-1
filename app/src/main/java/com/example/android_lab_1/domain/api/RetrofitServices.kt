package com.example.android_lab_1.domain.api

import com.example.android_lab_1.domain.data.Balance
import com.example.android_lab_1.domain.data.Tariff
import com.example.android_lab_1.domain.data.UserInfoData
import retrofit2.http.GET

interface RetrofitServices {

    @GET("balance")
    suspend fun getBalance(): List<Balance>

    @GET("userInfo")
    suspend fun getUserInfo(): List<UserInfoData>

    @GET("tariffs")
    suspend fun getTariffs(): List<Tariff>

}