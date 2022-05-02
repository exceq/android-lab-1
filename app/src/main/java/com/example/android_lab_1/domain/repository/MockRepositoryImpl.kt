package com.example.android_lab_1.domain.repository

import com.example.android_lab_1.domain.api.RetrofitServices
import com.example.android_lab_1.domain.data.Balance
import com.example.android_lab_1.domain.data.Tariff
import com.example.android_lab_1.domain.data.UserInfoData
import javax.inject.Inject

class MockRepositoryImpl @Inject constructor(
    private val retrofitServices: RetrofitServices
) : MockRepository {

    override suspend fun getBalance(): List<Balance> = retrofitServices.getBalance()

    override suspend fun getUserInfo(): List<UserInfoData> = retrofitServices.getUserInfo()

    override suspend fun getTariffs(): List<Tariff> = retrofitServices.getTariffs()

}