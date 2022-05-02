package com.example.android_lab_1.repository

import com.example.android_lab_1.api.RetrofitServices
import com.example.android_lab_1.data.Balance
import com.example.android_lab_1.data.Tariff
import com.example.android_lab_1.data.UserInfoData
import javax.inject.Inject

class MockRepositoryImpl @Inject constructor(
    private val retrofitServices: RetrofitServices
) : MockRepository {

    override suspend fun getBalance(): List<Balance> = retrofitServices.getBalance()

    override suspend fun getUserInfo(): List<UserInfoData> = retrofitServices.getUserInfo()

    override suspend fun getTariffs(): List<Tariff> = retrofitServices.getTariffs()

}