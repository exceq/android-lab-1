package com.example.android_lab_1.domain.data

import com.google.gson.annotations.SerializedName

data class Balance(
    @SerializedName("accNum")
    val accountNumber: Int,
    @SerializedName("balance")
    val balance: Double,
    @SerializedName("nextPay")
    val nextPay: Double,
    @SerializedName("id")
    val id: Int,
) : RecycleViewItem

