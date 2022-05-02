package com.example.android_lab_1.domain.repository

import com.example.android_lab_1.domain.data.Balance
import com.example.android_lab_1.domain.data.Tariff
import com.example.android_lab_1.domain.data.UserInfoData

interface MockRepository {
    suspend fun getBalance(): List<Balance>

    suspend fun getUserInfo(): List<UserInfoData>

    suspend fun getTariffs(): List<Tariff>
}