package com.example.android_lab_1.domain.data.room.dao

import androidx.room.*
import com.example.android_lab_1.domain.data.Tariff

@Dao
interface TariffDao {

    @Query("SELECT * FROM ${Tariff.TABLE_NAME}")
    suspend fun getTariffList(): List<Tariff>

    @Insert(entity = Tariff::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTariffLocal(balance: Tariff)

    @Delete
    suspend fun deleteTariff(tariff: Tariff)
}