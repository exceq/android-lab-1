package com.example.android_lab_1.domain.repository

import android.content.Context
import android.util.Log
import com.example.android_lab_1.R
import com.example.android_lab_1.domain.api.MockApiService
import com.example.android_lab_1.domain.data.Balance
import com.example.android_lab_1.domain.data.Tariff
import com.example.android_lab_1.domain.data.UserInfoData
import com.example.android_lab_1.domain.data.room.MockDatabase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ResourceProvider @Inject constructor(val context: Context) {
    fun getString(int: Int): String {
        return context.resources.getString(int)
    }
}

class MockRepositoryRemoteImpl @Inject constructor(
    private val mockApiService: MockApiService,
    private val mockDatabase: MockDatabase,
    private val context: Context
) : MockRepository {

    override suspend fun getBalanceList(): List<Balance> {
        val balanceList = mockApiService.getBalanceList()
        balanceList.forEach {
            mockDatabase.getBalanceDao().saveBalanceLocal(it)
        }
        //Log.e("TAG_LOCAL", mockDatabase.getBalanceDao().getBalanceList().toString())
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
        tariffList.forEach {
            mockDatabase.getTariffDao().saveTariffLocal(it)
        }
        return tariffList
    }

}