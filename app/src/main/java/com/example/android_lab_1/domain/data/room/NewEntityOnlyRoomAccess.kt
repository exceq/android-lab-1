package com.example.android_lab_1.domain.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "entity")
data class NewEntityOnlyRoomAccess(
    @ColumnInfo(name = "id")
    @PrimaryKey
    val id: Int,
)