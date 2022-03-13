package com.example.android_lab_1

data class BalanceItem(
    override val title: String,
    val personId: Long,
    val currentBalance: Double,
    val currentMonth: String,
    val toPayForMonth: Double
) : Item(title)
