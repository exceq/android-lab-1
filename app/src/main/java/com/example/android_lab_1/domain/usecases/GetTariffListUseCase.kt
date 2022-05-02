package com.example.android_lab_1.domain.usecases

import com.example.android_lab_1.domain.data.Tariff

interface GetTariffListUseCase {
    suspend operator fun invoke(): List<Tariff>
}