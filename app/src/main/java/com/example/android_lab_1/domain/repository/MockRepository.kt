package com.example.android_lab_1.domain.repository

import com.example.android_lab_1.domain.data.Balance
import com.example.android_lab_1.domain.data.Tariff
import com.example.android_lab_1.domain.data.UserInfoData

interface MockRepository {
    suspend fun getBalanceList(): List<Balance>

    suspend fun getUserInfoDataList(): List<UserInfoData>

    suspend fun getTariffList(): List<Tariff>
}