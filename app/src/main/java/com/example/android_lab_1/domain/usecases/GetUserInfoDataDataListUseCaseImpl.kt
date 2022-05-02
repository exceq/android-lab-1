package com.example.android_lab_1.domain.usecases

import com.example.android_lab_1.domain.data.UserInfoData
import com.example.android_lab_1.domain.repository.MockRepository
import javax.inject.Inject

class GetUserInfoDataDataListUseCaseImpl @Inject constructor(
    private val mockRepository: MockRepository
) : GetUserInfoDataListUseCase {
    override suspend fun invoke(): List<UserInfoData> = mockRepository.getUserInfoDataList()
}