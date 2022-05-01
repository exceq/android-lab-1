package com.example.android_lab_1.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.android_lab_1.R
import com.example.android_lab_1.data.RecycleViewItem

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private val adapter = ItemAdapter()
    private val items: MutableList<RecycleViewItem> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.accountItems)

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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.getDataForProfile()
            .observe(viewLifecycleOwner) { viewItems ->
                items.addAll(viewItems);
                adapter.submitList(items)
            }
    }
}