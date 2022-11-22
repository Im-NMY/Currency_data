package com.example.currency_data.data.network.currencylist

import com.example.currency_data.data.network.currencylist.model.RatesRemoteModel

class RatesRemoteSource(private val api: CurrencyListApi) {

    suspend fun getRates(pairs: String): RatesRemoteModel = api.getCurrencyList(pairs = pairs)
}