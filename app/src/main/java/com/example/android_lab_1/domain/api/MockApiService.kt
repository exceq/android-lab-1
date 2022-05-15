package com.example.android_lab_1.domain.api

import com.example.android_lab_1.domain.data.Balance
import com.example.android_lab_1.domain.data.Tariff
import com.example.android_lab_1.domain.data.UserInfoData
import retrofit2.http.GET

interface MockApiService {

    @GET("balance")
    suspend fun getBalanceList(): List<Balance>

    @GET("userInfo")
    suspend fun getUserInfoList(): List<UserInfoData>

    @GET("tariffs")
    suspend fun getTariffList(): List<Tariff>

}