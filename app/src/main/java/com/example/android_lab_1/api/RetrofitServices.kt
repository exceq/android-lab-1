package com.example.android_lab_1.api

import com.example.android_lab_1.data.Balance
import com.example.android_lab_1.data.Tariff
import com.example.android_lab_1.data.UserInfo
import retrofit2.http.GET

interface RetrofitServices {

    @GET("balance")
    fun getBalance(): Balance

    @GET("userInfo")
    fun getUserInfo(): UserInfo

    @GET("tariffs")
    fun getTariffs(): List<Tariff>


}