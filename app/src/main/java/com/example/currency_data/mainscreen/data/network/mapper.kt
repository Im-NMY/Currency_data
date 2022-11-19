package com.example.currency_data.mainscreen.data.network

import com.example.currency_data.base.Item
import com.example.currency_data.mainscreen.data.network.rateslist.model.CurrencyListRemoteModel
import com.example.currency_data.mainscreen.domain.CurrencyListModel

fun CurrencyListRemoteModel.toDomain() = CurrencyListModel(
    data = data
)