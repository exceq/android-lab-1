package com.example.android_lab_1.domain.repository

import com.example.android_lab_1.domain.data.Balance
import com.example.android_lab_1.domain.data.Tariff
import com.example.android_lab_1.domain.data.UserInfoData
import com.example.android_lab_1.domain.data.room.MockDatabase
import javax.inject.Inject

class MockRepositoryLocalImpl @Inject constructor(
    private val mockDatabase: MockDatabase
) : MockRepository {
    override suspend fun getBalanceList(): List<Balance> {
        return mockDatabase.getBalanceDao().getBalanceList()
    }

    override suspend fun getUserInfoDataList(): List<UserInfoData> {
        return mockDatabase.getUserInfoDataDao().getUserInfoDataList()
    }

    override suspend fun getTariffList(): List<Tariff> {
        return mockDatabase.getTariffDao().getTariffList()
    }
}