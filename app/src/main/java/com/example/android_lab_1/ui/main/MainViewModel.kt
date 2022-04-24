package com.example.android_lab_1.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.android_lab_1.api.RetrofitClient
import com.example.android_lab_1.data.Balance
import com.example.android_lab_1.data.Tariff
import com.example.android_lab_1.data.UserInfo

class MainViewModel : ViewModel() {
    init {
        val balance = getBalance()
        val tariffs = getTariffs()
        val userInfo = getUserInfo()
    }
    fun getBalance() = liveData {
        val balance : Balance = RetrofitClient.retrofitService.getBalance()
        balance.title = "Ваш баланс"
        emit(balance)
    }

    fun getTariffs() = liveData {
        val tariffs : List<Tariff> =  RetrofitClient.retrofitService.getTariffs()
        emit(tariffs)
    }

    fun getUserInfo() = liveData {
        val userInfo : UserInfo = RetrofitClient.retrofitService.getUserInfo()
        userInfo.title = "Ваш профиль"
        emit(userInfo)
    }
}