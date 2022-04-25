package com.example.android_lab_1.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android_lab_1.*
import com.example.android_lab_1.data.*

class ItemAdapter : ListAdapter<RecycleViewItem, ItemAdapter.ViewHolder>(ItemDiffCallback()) {

    companion object {
        const val BALANCE: Int = 0
        const val CATEGORY: Int = 1
        const val TARIFF: Int = 2
        const val USER_INFO: Int = 3
        const val BIG_TITLE: Int = 4
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        @SuppressLint("SetTextI18n")
        fun bind(item: RecycleViewItem) {
            when (item) {
                is Balance -> {
                    itemView.findViewById<TextView>(R.id.balanceTitle).text = "Ваш баланс" //item.title
                    itemView.findViewById<TextView>(R.id.personId).text = item.accountNumber.toString()
                    itemView.findViewById<TextView>(R.id.currentBalance).text = "${item.balance} ₽"
                    val toPayTitle = itemView.findViewById<TextView>(R.id.toPayForMonthTitle)
                    toPayTitle.text = "К оплате за месяц: ${item.nextPay} ₽"
                }
                is Tariff -> {
                    itemView.findViewById<TextView>(R.id.tariffTitle).text = item.title
                    itemView.findViewById<TextView>(R.id.tariffDescription).text = item.description
                    itemView.findViewById<TextView>(R.id.perMonthPrice).text = "${item.cost} ₽"
                }
                is CategoryTitle -> {
                    itemView.findViewById<TextView>(R.id.categoryTitle).text = item.title
                }
                is UserInfo -> {
                    itemView.findViewById<TextView>(R.id.infoText).text = item.title
//                    itemView.findViewById<ImageView>(R.id.infoIcon).setImageDrawable(item.profileIcon) // TODO картинку профиля
                }
                is BigTitle -> {
                    itemView.findViewById<TextView>(R.id.accountTitle).text = item.title
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = when (viewType) {
            BALANCE -> LayoutInflater.from(parent.context)
                .inflate(R.layout.balance_item, parent, false)
            CATEGORY -> LayoutInflater.from(parent.context)
                .inflate(R.layout.category_title, parent, false)
            TARIFF -> LayoutInflater.from(parent.context)
                .inflate(R.layout.tariff_item, parent, false)
            USER_INFO -> LayoutInflater.from(parent.context)
                .inflate(R.layout.user_info, parent, false)
            BIG_TITLE -> LayoutInflater.from(parent.context)
                .inflate(R.layout.big_title, parent, false)
            else -> throw Exception("Unknown viewType")
        }

        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return when (currentList[position]) {
            is Balance -> BALANCE
            is CategoryTitle -> CATEGORY
            is Tariff -> TARIFF
            is UserInfo -> USER_INFO
            is BigTitle -> BIG_TITLE
            else -> -1
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }


    class ItemDiffCallback : DiffUtil.ItemCallback<RecycleViewItem>() {
        override fun areItemsTheSame(oldItem: RecycleViewItem, newItem: RecycleViewItem): Boolean =
            oldItem === newItem

        override fun areContentsTheSame(oldItem: RecycleViewItem, newItem: RecycleViewItem): Boolean =
            oldItem.hashCode() == newItem.hashCode()
    }
}