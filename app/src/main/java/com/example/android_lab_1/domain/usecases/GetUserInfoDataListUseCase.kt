package com.example.android_lab_1.domain.usecases

import com.example.android_lab_1.domain.data.UserInfoData

interface GetUserInfoDataListUseCase {
    suspend operator fun invoke(): List<UserInfoData>
}