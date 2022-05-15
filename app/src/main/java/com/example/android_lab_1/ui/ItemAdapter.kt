package com.example.android_lab_1.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android_lab_1.R
import com.example.android_lab_1.databinding.*
import com.example.android_lab_1.domain.data.*
import com.example.android_lab_1.domain.data.Balance
import com.example.android_lab_1.domain.data.Tariff

class ItemAdapter : ListAdapter<RecycleViewItem, ItemAdapter.ViewHolder>(ItemDiffCallback()) {

    companion object {
        const val BALANCE: Int = 0
        const val CATEGORY: Int = 1
        const val TARIFF: Int = 2
        const val USER_INFO: Int = 3
        const val BIG_TITLE: Int = 4
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val balanceItemBinding: BalanceItemBinding by viewBinding()
        private val tariffItemBinding: TariffItemBinding by viewBinding()
        private val categoryTitleBinding: CategoryTitleBinding by viewBinding()
        private val userInfoBinding: UserInfoBinding by viewBinding()
        private val bigTitleBinding: BigTitleBinding by viewBinding()

        @SuppressLint("SetTextI18n")
        fun bind(item: RecycleViewItem) {
            when (item) {
                is Balance -> {
                    balanceItemBinding.balanceTitle.text = "Ваш баланс" //item.title
                    balanceItemBinding.personId.text = item.accountNumber.toString()
                    balanceItemBinding.currentBalance.text = "${item.balance} ₽"
                    balanceItemBinding.toPayForMonthTitle.text = "К оплате за месяц: ${item.nextPay} ₽"
                }
                is Tariff -> {
                    tariffItemBinding.tariffTitle.text = item.title
                    tariffItemBinding.tariffDescription.text = item.description
                    tariffItemBinding.perMonthPrice.text = "${item.cost} ₽"
                }
                is CategoryTitle -> {
                    categoryTitleBinding.categoryTitle.text = item.title
                }
                is UserInfo -> {
                    userInfoBinding.infoText.text = item.title
//                    userInfoBinding.infoIcon.setImageDrawable(item.profileIcon) // TODO картинку профиля
                }
                is BigTitle -> {
                    bigTitleBinding.accountTitle.text = item.title
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

        override fun areContentsTheSame(
            oldItem: RecycleViewItem,
            newItem: RecycleViewItem
        ): Boolean =
            oldItem.hashCode() == newItem.hashCode()
    }
}