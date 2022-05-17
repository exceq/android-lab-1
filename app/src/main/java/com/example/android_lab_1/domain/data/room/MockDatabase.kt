package com.example.android_lab_1.domain.data.room

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.android_lab_1.domain.data.Balance
import com.example.android_lab_1.domain.data.Tariff
import com.example.android_lab_1.domain.data.UserInfoData
import com.example.android_lab_1.domain.data.room.dao.*

@Database(
    entities = [
        Balance::class,
        Tariff::class,
        UserInfoData::class,
        NewEntityOnlyRoomAccess::class
    ],
    autoMigrations = [
        AutoMigration (from = 1, to = 2)
    ], version = 2, exportSchema = true
)
abstract class MockDatabase : RoomDatabase() {
    abstract fun getBalanceDao(): BalanceDao
    abstract fun getTariffDao(): TariffDao
    abstract fun getUserInfoDataDao(): UserInfoDataDao

    companion object {
        const val DATABASE_NAME = "my_database"
    }
}