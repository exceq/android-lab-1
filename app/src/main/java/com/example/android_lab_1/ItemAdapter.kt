package com.example.android_lab_1

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter : ListAdapter<Item, ItemAdapter.ViewHolder>(ItemDiffCallback()) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        @SuppressLint("SetTextI18n")
        fun bind(item: Item) {
            when (item) {
                is BalanceItem -> {
                    itemView.findViewById<TextView>(R.id.balanceTitle).text = item.title
                    itemView.findViewById<TextView>(R.id.personId).text = item.personId.toString()
                    itemView.findViewById<TextView>(R.id.currentBalance).text =
                        "${item.currentBalance} ₽"
                    val toPayTitle = itemView.findViewById<TextView>(R.id.toPayForMonthTitle)
                    toPayTitle.text = "К оплате за ${item.currentMonth}: ${item.toPayForMonth} ₽"
                }
                is TariffItem -> {
                    itemView.findViewById<TextView>(R.id.tariffTitle).text = item.title
                    itemView.findViewById<TextView>(R.id.tariffDescription).text = item.description
                    itemView.findViewById<TextView>(R.id.perMonthPrice).text = "${item.price} ₽"
                }
                is CategoryTitleItem -> {
                    itemView.findViewById<TextView>(R.id.categoryTitle).text = item.title
                }
                is UserInfoItem -> {
                    itemView.findViewById<TextView>(R.id.infoText).text = item.title
                    itemView.findViewById<ImageView>(R.id.infoIcon).setImageDrawable(item.icon)
                }
            }
        }
    }

    companion object {
        const val BALANCE: Int = 0
        const val CATEGORY: Int = 1
        const val TARIFF: Int = 2
        const val USER_INFO: Int = 3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {
        val view: View = when (viewType) {
            BALANCE -> LayoutInflater.from(parent.context)
                .inflate(R.layout.balance_item, parent, false)
            CATEGORY -> LayoutInflater.from(parent.context)
                .inflate(R.layout.category_title, parent, false)
            TARIFF -> LayoutInflater.from(parent.context)
                .inflate(R.layout.tariff_item, parent, false)
            USER_INFO -> LayoutInflater.from(parent.context)
                .inflate(R.layout.user_info, parent, false)
            else -> throw Exception("Unknown viewType")
        }

        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return when (currentList[position]) {
            is BalanceItem -> BALANCE
            is CategoryTitleItem -> CATEGORY
            is TariffItem -> TARIFF
            is UserInfoItem -> USER_INFO
            else -> -1
        }
    }

    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }


    class ItemDiffCallback : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean =
            oldItem === newItem

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean =
            oldItem == newItem
    }
}