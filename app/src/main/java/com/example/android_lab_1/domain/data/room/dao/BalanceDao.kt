package com.example.android_lab_1.domain.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android_lab_1.domain.data.Balance

@Dao
interface BalanceDao {

    @Query("SELECT * FROM ${Balance.TABLE_NAME}")
    suspend fun getBalanceList(): List<Balance>

    @Insert(entity = Balance::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveBalanceLocal(balance: Balance)
}