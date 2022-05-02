package com.example.android_lab_1.domain.usecases

import com.example.android_lab_1.domain.data.Balance
import com.example.android_lab_1.domain.repository.MockRepository
import javax.inject.Inject

class GetBalanceListUseCaseImpl @Inject constructor(
    private val mockRepository: MockRepository
) : GetBalanceListUseCase {
    override suspend fun invoke(): List<Balance> = mockRepository.getBalanceList()
}