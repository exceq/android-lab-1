package com.example.android_lab_1.domain.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android_lab_1.domain.data.UserInfoData

@Dao
interface UserInfoDataDao {

    @Query("SELECT * FROM ${UserInfoData.TABLE_NAME}")
    suspend fun getUserInfoDataList(): List<UserInfoData>

    @Insert(entity = UserInfoData::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUserInfoDataLocal(balance: UserInfoData)
}