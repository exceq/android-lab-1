package com.example.android_lab_1.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.android_lab_1.domain.data.BigTitle
import com.example.android_lab_1.domain.data.CategoryTitle
import com.example.android_lab_1.domain.data.RecycleViewItem
import com.example.android_lab_1.domain.data.UserInfo
import com.example.android_lab_1.domain.usecases.GetBalanceListUseCase
import com.example.android_lab_1.domain.usecases.GetTariffListUseCase
import com.example.android_lab_1.domain.usecases.GetUserInfoDataListUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getBalanceListUseCase : GetBalanceListUseCase,
    private val getTariffListUseCase : GetTariffListUseCase,
    private val getUserInfoDataListUseCase : GetUserInfoDataListUseCase
) : ViewModel() {

    fun getDataForProfile() = liveData {
        val viewItems = ArrayList<RecycleViewItem>()
        viewItems.add(BigTitle("Личный кабинет"))
        viewItems.addAll(getBalanceListUseCase())
        viewItems.add(CategoryTitle("Тариф"))
        viewItems.addAll(getTariffListUseCase())
        viewItems.add(CategoryTitle("Пользователь"))

        val userData = getUserInfoDataListUseCase()
        viewItems.add(UserInfo(userData[0].address))
        viewItems.add(UserInfo(userData[0].firstName + " " + userData[0].lastName))

        emit(viewItems)
    }
}