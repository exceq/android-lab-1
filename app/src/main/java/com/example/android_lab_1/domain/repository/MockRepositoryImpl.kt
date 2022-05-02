package com.example.android_lab_1.domain.repository

import com.example.android_lab_1.domain.api.MockApiService
import com.example.android_lab_1.domain.data.Balance
import com.example.android_lab_1.domain.data.Tariff
import com.example.android_lab_1.domain.data.UserInfoData
import javax.inject.Inject

class MockRepositoryImpl @Inject constructor(
    private val mockApiService: MockApiService
) : MockRepository {

    override suspend fun getBalanceList(): List<Balance> = mockApiService.getBalance()

    override suspend fun getUserInfoDataList(): List<UserInfoData> = mockApiService.getUserInfo()

    override suspend fun getTariffList(): List<Tariff> = mockApiService.getTariffs()

}