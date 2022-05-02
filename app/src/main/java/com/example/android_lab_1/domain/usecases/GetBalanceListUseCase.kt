package com.example.android_lab_1.domain.usecases

import com.example.android_lab_1.domain.data.Balance

interface GetBalanceListUseCase {
    suspend operator fun invoke(): List<Balance>
}