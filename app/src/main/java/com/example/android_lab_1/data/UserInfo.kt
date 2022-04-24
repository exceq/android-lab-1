package com.example.android_lab_1.data

import android.graphics.drawable.Drawable
import com.google.gson.annotations.SerializedName

data class UserInfo(
    @SerializedName("id")
    val id: Int,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("address")
    val address: String,

    var profileIcon : Drawable?,

    override var title : String
) : RecycleViewItem(title)
