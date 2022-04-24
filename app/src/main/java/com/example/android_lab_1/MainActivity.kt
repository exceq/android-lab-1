package com.example.android_lab_1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items: List<Item> = mutableListOf(

            BigTitleItem("Личный кабинет"),

            BalanceItem("Ваш баланс", 1100011L, 431.14, "март", 100.0),

            CategoryTitleItem("Тариф"),

            TariffItem("Тариф «Улыбка (бесплатный)» ligma some text", "Скорость до 100 Мбит/с", 0),
            TariffItem("Тариф «Улыбка (бесплатный)» ligma some text", "Скорость до 100 Мбит/с", 0),
            TariffItem("Тариф «Улыбка (бесплатный)» ligma some text", "Скорость до 100 Мбит/с", 0),
            TariffItem("Тариф «Улыбка (не бесплатный)» ligma some text","Скорость до 200 Мбит/с",99),

            CategoryTitleItem("Пользователь"),

            UserInfoItem("Иванов Иван Иванович",applicationContext.getDrawable(R.drawable.ic_baseline_account_circle_24)),
            UserInfoItem("Челябинск, ул. Кирова, д.2", applicationContext.getDrawable(R.drawable.ic_round_home_24)),
            UserInfoItem("Доступные услуги", applicationContext.getDrawable(R.drawable.ic_baseline_widgets_24)),
        )

        val recyclerView = findViewById<RecyclerView>(R.id.accountItems)
        val adapter = ItemAdapter()
        adapter.submitList(items)

        // Фон с круглыми углами для тарифа
        recyclerView.addItemDecoration(
            RoundItemDecorator(
                ResourcesCompat.getDrawable(resources, R.drawable.background_tariff, null)!!,
                ItemAdapter.TARIFF
            )
        )

        // Фон с круглыми углами для юзер инфы
        recyclerView.addItemDecoration(
            RoundItemDecorator(
                ResourcesCompat.getDrawable(resources, R.drawable.background_user_info, null)!!,
                ItemAdapter.USER_INFO
            )
        )

        // Разделители
        recyclerView.addItemDecoration(
            DividerItemDecorator(
                ResourcesCompat.getDrawable(resources, R.drawable.divider, null)!!
            )
        )

        recyclerView.adapter = adapter
    }
}