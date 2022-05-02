package com.example.android_lab_1.repository

import com.example.android_lab_1.data.Balance
import com.example.android_lab_1.data.Tariff
import com.example.android_lab_1.data.UserInfoData

interface MockRepository {
    suspend fun getBalance(): List<Balance>

    suspend fun getUserInfo(): List<UserInfoData>

    suspend fun getTariffs(): List<Tariff>
}