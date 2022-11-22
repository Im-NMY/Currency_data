package com.example.currency_data.data.network

import com.example.currency_data.data.network.currencylist.RatesRemoteSource
import com.example.currency_data.data.network.rateslist.CurrencyRemoteSource
import com.example.currency_data.domain.ListItemModel

class RatesRepositoryImpl(private val ratesSource: RatesRemoteSource, private val source: CurrencyRemoteSource) :
    RatesRepository {

    override suspend fun getRates(pairs: String): ListItemModel {
        return ratesSource.getRates(pairs).toDomain()
    }

    override suspend fun getCurrencyList(): List<String> {
        return source.getCurrencyList()
    }
}