package com.example.android_lab_1

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.android_lab_1.data.*
import com.example.android_lab_1.ui.main.DividerItemDecorator
import com.example.android_lab_1.ui.main.ItemAdapter
import com.example.android_lab_1.ui.main.RoundItemDecorator
import com.example.android_lab_1.api.RetrofitClient
import com.example.android_lab_1.ui.main.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val adapter = ItemAdapter()
    private val items: MutableList<RecycleViewItem> = mutableListOf()

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.getDataForProfile()
            .observe(this) { viewItems ->
                items.addAll(viewItems);
                adapter.submitList(items)
            }

//        userInfo.value?.profileIcon =
//            applicationContext.getDrawable(R.drawable.ic_baseline_account_circle_24)

        val recyclerView = findViewById<RecyclerView>(R.id.accountItems)

        //region декораторы
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
        //endregion

        recyclerView.adapter = adapter
    }
}