package com.example.android_lab_1.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.android_lab_1.domain.api.RetrofitServices
import com.example.android_lab_1.domain.data.BigTitle
import com.example.android_lab_1.domain.data.CategoryTitle
import com.example.android_lab_1.domain.data.RecycleViewItem
import com.example.android_lab_1.domain.data.UserInfo
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val retrofitServices: RetrofitServices
) : ViewModel() {

    fun getDataForProfile() = liveData {
        val viewItems = ArrayList<RecycleViewItem>()
        viewItems.add(BigTitle("Личный кабинет"))
        viewItems.addAll(retrofitServices.getBalance())
        viewItems.add(CategoryTitle("Тариф"))
        viewItems.addAll(retrofitServices.getTariffs())
        viewItems.add(CategoryTitle("Пользователь"))

        val userData = retrofitServices.getUserInfo()
        viewItems.add(UserInfo(userData[0].address))
        viewItems.add(UserInfo(userData[0].firstName + " " + userData[0].lastName))

        emit(viewItems)
    }
}