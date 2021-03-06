package com.example.android_lab_1.di

import android.content.Context
import androidx.room.Room
import com.example.android_lab_1.domain.data.room.MockDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class MockDatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): MockDatabase =
        Room.databaseBuilder(
            context,
            MockDatabase::class.java,
            MockDatabase.DATABASE_NAME
        ).build()

    @Provides
    fun providesBalanceDao(database: MockDatabase) = database.getBalanceDao()

    @Provides
    fun providesTariffDao(database: MockDatabase) = database.getTariffDao()

    @Provides
    fun providesUserInfoDataDao(database: MockDatabase) = database.getUserInfoDataDao()
}