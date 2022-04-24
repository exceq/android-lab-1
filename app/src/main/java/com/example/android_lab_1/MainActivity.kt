package com.example.android_lab_1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.android_lab_1.data.*
import com.example.android_lab_1.ui.main.DividerItemDecorator
import com.example.android_lab_1.ui.main.ItemAdapter
import com.example.android_lab_1.ui.main.RoundItemDecorator
import com.example.android_lab_1.api.RetrofitClient
import com.example.android_lab_1.ui.main.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel


    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        val balance = viewModel.getBalance()
        val tariffs = viewModel.getTariffs()
        val userInfo = viewModel.getUserInfo()


//        val balance : Balance = RetrofitClient.retrofitService.getBalance()
//        balance.title = "Ваш баланс"
//
//        val tariffs = RetrofitClient.retrofitService.getTariffs()
//        val userInfo : UserInfo = RetrofitClient.retrofitService.getUserInfo()
        userInfo.value?.profileIcon =
            applicationContext.getDrawable(R.drawable.ic_baseline_account_circle_24)

        val items: MutableList<RecycleViewItem> = mutableListOf(
            BigTitle("Личный кабинет"),
            balance.value!!,
            CategoryTitle("Тариф")
        )
        items.addAll(tariffs.value!!)
        items.add(CategoryTitle("Пользователь"))
        items.add(userInfo.value!!)

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