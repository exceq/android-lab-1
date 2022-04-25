package com.example.android_lab_1.api

import com.example.android_lab_1.data.Balance
import com.example.android_lab_1.data.Tariff
import com.example.android_lab_1.data.UserInfoData
import retrofit2.http.GET

interface RetrofitServices {

    @GET("balance")
    suspend fun getBalance(): List<Balance>

    @GET("userInfo")
    suspend fun getUserInfo(): List<UserInfoData>

    @GET("tariffs")
    suspend fun getTariffs(): List<Tariff>

}