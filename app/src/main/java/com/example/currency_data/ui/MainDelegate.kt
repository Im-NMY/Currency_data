package com.example.currency_data.ui

import android.widget.ImageView
import com.example.currency_data.base.Item
import com.example.currency_data.databinding.ItemCorrencyBinding
import com.example.currency_data.domain.ItemModel
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object MainDelegate {

    fun currencyDelegate(
        onClick: (Int) -> Unit
    ) =
        adapterDelegateViewBinding<ItemModel, Item, ItemCorrencyBinding>(
            { inflater, container -> ItemCorrencyBinding.inflate(inflater, container, false) }
        ) {
            bind {
                binding.tvCurrency.text = item.currency
                binding.tvRate.text = item.value
                binding.ivBtn.visibility = if (!item.flag) ImageView.VISIBLE else ImageView.GONE
                binding.ivResult.visibility = if (item.flag) ImageView.VISIBLE else ImageView.GONE
                binding.ivBtn.setOnClickListener {
                    onClick.invoke(bindingAdapterPosition)
                    it.visibility = ImageView.GONE
                    binding.ivResult.visibility = ImageView.VISIBLE
                }
            }
        }
}