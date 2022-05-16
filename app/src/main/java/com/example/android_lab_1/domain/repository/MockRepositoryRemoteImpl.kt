package com.example.android_lab_1.domain.repository

import android.util.Log
import com.example.android_lab_1.domain.api.MockApiService
import com.example.android_lab_1.domain.data.Balance
import com.example.android_lab_1.domain.data.Tariff
import com.example.android_lab_1.domain.data.UserInfoData
import com.example.android_lab_1.domain.data.room.MockDatabase
import javax.inject.Inject

class MockRepositoryRemoteImpl @Inject constructor(
    private val mockApiService: MockApiService,
    private val mockDatabase: MockDatabase
) : MockRepository {

    override suspend fun getBalanceList(): List<Balance> {
        val balanceList = mockApiService.getBalanceList()
        balanceList.forEach {
            mockDatabase.getBalanceDao().saveBalanceLocal(it)
        }
        return balanceList
    }

    override suspend fun getUserInfoDataList(): List<UserInfoData> {
        val userInfoList = mockApiService.getUserInfoList()
        userInfoList.forEach {
            mockDatabase.getUserInfoDataDao().saveUserInfoDataLocal(it)
        }
        return userInfoList
    }

    override suspend fun getTariffList(): List<Tariff> {
        val tariffList = mockApiService.getTariffList()

        Log.e("TAG_remote", tariffList.toString())

        Log.e("TAG_local_before", mockDatabase.getTariffDao().getTariffList().toString())
        tariffList.forEach {
            mockDatabase.getTariffDao().saveTariffLocal(it) // сохранение работает
        }

        Log.e("TAG_local", mockDatabase.getTariffDao().getTariffList().toString())
        tariffList.forEach {
            mockDatabase.getTariffDao().deleteTariff(it) // удаление работает
        }

        Log.e("TAG_local_after_delete", mockDatabase.getTariffDao().getTariffList().toString())

        return tariffList
    }

}