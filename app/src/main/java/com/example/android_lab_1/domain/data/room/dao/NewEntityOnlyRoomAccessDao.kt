package com.example.android_lab_1.domain.data.room.dao

import androidx.room.*
import com.example.android_lab_1.domain.data.room.NewEntityOnlyRoomAccess

@Dao
interface NewEntityOnlyRoomAccessDao {
    @Query("SELECT * FROM entity")
    suspend fun getNewEntityOnlyRoomAccessList(): List<NewEntityOnlyRoomAccess>

    @Insert(entity = NewEntityOnlyRoomAccess::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveNewEntityOnlyRoomAccess(newEntityOnlyRoomAccess: NewEntityOnlyRoomAccess)

    @Delete
    suspend fun deleteNewEntityOnlyRoomAccess(newEntityOnlyRoomAccess: NewEntityOnlyRoomAccess)
}