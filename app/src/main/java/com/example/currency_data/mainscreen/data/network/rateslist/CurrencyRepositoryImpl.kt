package com.example.currency_data.mainscreen.data.network.rateslist

class CurrencyRepositoryImpl(private val source: CurrencyRemoteSource): CurrencyRepository {

    override suspend fun getCurrencyList(): List<String> {
        return source.getCurrencyList()
    }
}