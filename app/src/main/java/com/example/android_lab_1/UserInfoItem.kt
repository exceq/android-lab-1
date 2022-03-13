package com.example.android_lab_1

import android.graphics.drawable.Drawable

data class UserInfoItem(
    override val title: String,
    val icon: Drawable?
) : Item(title)
