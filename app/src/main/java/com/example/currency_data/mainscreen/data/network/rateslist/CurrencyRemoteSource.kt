package com.example.currency_data.mainscreen.data.network.rateslist

class CurrencyRemoteSource(private val api: CurrencyApi) {

    suspend fun getCurrencyList(): List<String> = api.getListCurrency().data

//    suspend fun getResultCurrencyList():CurrencyResultListRemoteModel = api.getResultListCurrency()
}