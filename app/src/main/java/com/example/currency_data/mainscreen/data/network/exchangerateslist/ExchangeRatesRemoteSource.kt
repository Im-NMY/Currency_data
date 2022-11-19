package com.example.currency_data.mainscreen.data.network.exchangerateslist

import com.example.currency_data.mainscreen.data.network.exchangerateslist.model.RatesRemoteModel
import retrofit2.Response

class ExchangeRatesRemoteSource(private val api: CurrencyListApi) {

    suspend fun getRates(pairs: String): Response<String> = api.getCurrencyList(pairs = pairs)
}