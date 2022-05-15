package com.example.android_lab_1.domain.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = Tariff.TABLE_NAME)
data class Tariff (
    @SerializedName("id")
    @ColumnInfo(name = "id")
    @PrimaryKey
    val id: Int,

    @SerializedName("desc")
    @ColumnInfo(name = "desc")
    val description: String,

    @SerializedName("cost")
    @ColumnInfo(name = "cost")
    val cost: Double,

    @SerializedName("title")
    @ColumnInfo(name = "title")
    val title: String,

) : RecycleViewItem {
    companion object {
        const val TABLE_NAME = "tariff"
    }
}
