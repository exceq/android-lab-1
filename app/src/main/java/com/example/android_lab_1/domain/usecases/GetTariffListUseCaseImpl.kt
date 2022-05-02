package com.example.android_lab_1.domain.usecases

import com.example.android_lab_1.domain.data.Tariff
import com.example.android_lab_1.domain.repository.MockRepository
import javax.inject.Inject

class GetTariffListUseCaseImpl @Inject constructor(
    private val mockRepository: MockRepository
) : GetTariffListUseCase {
    override suspend fun invoke(): List<Tariff> = mockRepository.getTariffList()
}