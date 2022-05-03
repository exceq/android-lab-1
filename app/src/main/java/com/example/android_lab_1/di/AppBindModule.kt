package com.example.android_lab_1.di

import com.example.android_lab_1.domain.repository.MockRepository
import com.example.android_lab_1.domain.repository.MockRepositoryImpl
import com.example.android_lab_1.domain.usecases.*
import dagger.Binds
import dagger.Module

@Module
interface AppBindModule {

    @Binds
    fun bindMockRepositoryImplToMockRepository(
        mockRepositoryImpl: MockRepositoryImpl
    ): MockRepository

    @Binds
    fun bindGetBalanceListUseCase(useCase: GetBalanceListUseCaseImpl): GetBalanceListUseCase

    @Binds
    fun bindGetUserInfoDataListUseCase(useCase: GetUserInfoDataDataListUseCaseImpl): GetUserInfoDataListUseCase

    @Binds
    fun bindGetTariffsListUseCase(useCase: GetTariffListUseCaseImpl): GetTariffListUseCase
}
