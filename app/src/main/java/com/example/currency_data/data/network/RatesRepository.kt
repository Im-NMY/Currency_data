package com.example.currency_data.data.network

import com.example.currency_data.domain.ListItemModel

interface RatesRepository {

    suspend fun getRates(pairs: String): ListItemModel

    suspend fun getCurrencyList(): List<String>
}