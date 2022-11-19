package com.example.currency_data.mainscreen.data.network.exchangerateslist

import com.example.currency_data.mainscreen.data.network.exchangerateslist.model.RatesRemoteModel
import retrofit2.Response

class RatesRepositoryImpl(private val ratesSource: ExchangeRatesRemoteSource) : RatesRepository {

    override suspend fun getRates(pairs: String): Response<String> = ratesSource.getRates(pairs)
}