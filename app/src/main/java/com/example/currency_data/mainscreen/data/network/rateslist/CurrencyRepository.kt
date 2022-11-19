package com.example.currency_data.mainscreen.data.network.rateslist

import com.example.currency_data.mainscreen.domain.CurrencyListModel

interface CurrencyRepository {

    suspend fun getCurrencyList(): List<String>
}