package com.example.android_lab_1.domain.data

import com.google.gson.annotations.SerializedName

data class UserInfoData(
    @SerializedName("id")
    val id: Int,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("address")
    val address: String,
) : RecycleViewItem
