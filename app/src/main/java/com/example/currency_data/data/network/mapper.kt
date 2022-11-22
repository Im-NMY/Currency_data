package com.example.currency_data.data.network

import com.example.currency_data.data.network.currencylist.model.RatesRemoteModel
import com.example.currency_data.domain.ItemModel
import com.example.currency_data.domain.ListItemModel

fun RatesRemoteModel.toDomain() = ListItemModel(
    list = rates.map { ItemModel(currency = it.key, value = it.value) }
)