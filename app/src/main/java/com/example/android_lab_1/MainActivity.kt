package com.example.android_lab_1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items: List<Item> = mutableListOf(

            BalanceItem("Ваш баланс", 1100011L, 431.14, "март", 100.0),
            CategoryTitleItem("Тариф"),
            TariffItem("Тариф «Улыбка (бесплатный)» ligma some text", "Скорость до 100 Мбит/с", 0),
            TariffItem("Тариф «Улыбка (не бесплатный)» ligma some text", "Скорость до 200 Мбит/с", 99),
            CategoryTitleItem("Пользователь"),
            UserInfoItem("Иванов Иван Иванович", applicationContext.getDrawable(R.drawable.ic_baseline_account_circle_24)),
            UserInfoItem("Челябинск, ул. Кирова, д.2", applicationContext.getDrawable(R.drawable.ic_round_home_24)),
            UserInfoItem("Доступные услуги", applicationContext.getDrawable(R.drawable.ic_baseline_widgets_24)),
        )
        val recyclerView = findViewById<RecyclerView>(R.id.accountItems)

        val adapter = ItemAdapter()
        adapter.submitList(items)

        recyclerView.adapter = adapter
    }
}