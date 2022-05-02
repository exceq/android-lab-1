package com.example.android_lab_1.domain.data

import com.google.gson.annotations.SerializedName

data class Tariff (
    @SerializedName("id")
    val id: Int,
    @SerializedName("desc")
    val description: String,
    @SerializedName("cost")
    val cost: Double,
    @SerializedName("title")
    val title: String,
) : RecycleViewItem