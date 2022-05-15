package com.example.android_lab_1.domain.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = UserInfoData.TABLE_NAME)
data class UserInfoData(
    @SerializedName("id")
    @ColumnInfo(name = "id")
    @PrimaryKey
    val id: Int,

    @SerializedName("firstName")
    @ColumnInfo(name = "firstName")
    val firstName: String,

    @SerializedName("lastName")
    @ColumnInfo(name = "lastName")
    val lastName: String,

    @SerializedName("address")
    @ColumnInfo(name = "address")
    val address: String,

) {
    companion object {
        const val TABLE_NAME = "user_info"
    }
}
