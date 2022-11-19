package com.example.currency_data.ui

import com.example.currency_data.base.Item
import com.example.currency_data.databinding.ItemCorrencyBinding
import com.example.currency_data.mainscreen.domain.CurrencyListModel
import com.example.currency_data.mainscreen.domain.ListItemModel
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object MainDelegate {

    fun currencyDelegate() =
        adapterDelegateViewBinding<ListItemModel, Item, ItemCorrencyBinding>(
            {inflater, container -> ItemCorrencyBinding.inflate(inflater, container, false)}
        ){
           bind { binding.tvCurrency.text = item.value }
        }
}