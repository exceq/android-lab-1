package com.example.android_lab_1.domain.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = Balance.TABLE_NAME)
data class Balance(
    @SerializedName("accNum")
    @ColumnInfo(name = "accNum")
    @PrimaryKey
    val accountNumber: Int,

    @SerializedName("balance")
    @ColumnInfo(name = "balance")
    val balance: Double,

    @SerializedName("nextPay")
    @ColumnInfo(name = "nextPay")
    val nextPay: Double,

    @SerializedName("id")
    @ColumnInfo(name = "id")
    val id: Int,

) : RecycleViewItem {
    companion object {
        const val TABLE_NAME = "balance"
    }
}

