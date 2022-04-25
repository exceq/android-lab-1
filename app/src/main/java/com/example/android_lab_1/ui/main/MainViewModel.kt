package com.example.android_lab_1.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.android_lab_1.api.RetrofitClient
import com.example.android_lab_1.data.*

class MainViewModel : ViewModel() {

    fun getDataForProfile() = liveData {
        val viewItems = ArrayList<RecycleViewItem>()
        viewItems.add(BigTitle("Личный кабинет"))
        viewItems.addAll(RetrofitClient.retrofitService.getBalance())
        viewItems.add(CategoryTitle("Тариф"))
        viewItems.addAll(RetrofitClient.retrofitService.getTariffs())
        viewItems.add(CategoryTitle("Пользователь"))

        val userData = RetrofitClient.retrofitService.getUserInfo()
        viewItems.add(UserInfo(userData[0].address))
        viewItems.add(UserInfo(userData[0].firstName + " " + userData[0].lastName))

        emit(viewItems)
    }

    fun getBalance() = liveData {
        val balances: List<Balance> = RetrofitClient.retrofitService.getBalance()
        emit(balances)
    }

    fun getTariffs() = liveData {
        val tariffs: List<Tariff> = RetrofitClient.retrofitService.getTariffs()
        emit(tariffs)
    }

    fun getUserInfo() = liveData {
        val userInfos: List<UserInfoData> = RetrofitClient.retrofitService.getUserInfo()
        emit(userInfos)
    }
}