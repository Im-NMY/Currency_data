package com.example.currency_data.mainscreen.data.network.exchangerateslist

import com.example.currency_data.mainscreen.data.network.exchangerateslist.model.RatesRemoteModel

class ExchangeRatesRemoteSorce(private val api: CurrencyListApi) {

    suspend fun getRates():RatesRemoteModel = api.getCurrencyList()
}