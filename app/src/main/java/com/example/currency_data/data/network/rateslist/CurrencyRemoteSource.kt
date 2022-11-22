package com.example.currency_data.data.network.rateslist

class CurrencyRemoteSource(private val api: CurrencyApi) {

    suspend fun getCurrencyList(): List<String> = api.getListCurrency().data

}