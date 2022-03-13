package com.example.android_lab_1

data class TariffItem(
    override var title: String,
    val description: String,
    val price: Int
) : Item(title) {
    init {
        title = cutString(title, 24)
    }
}

fun cutString(string: String, maxLen: Int = 16): String {
    return if (string.length < maxLen) string else string.substring(0, maxLen - 3) + "..."
}
