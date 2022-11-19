package com.example.currency_data.mainscreen.domain

import com.example.currency_data.base.attempt
import com.example.currency_data.mainscreen.data.network.exchangerateslist.RatesRepository
import com.example.currency_data.mainscreen.data.network.rateslist.CurrencyRepository

class Interactor(private val currencyRepository: CurrencyRepository, private val ratesRepository: RatesRepository) {

    suspend fun getCurrencyList() = attempt { currencyRepository.getCurrencyList() }

    suspend fun getRatesList(pairs: String) = attempt { ratesRepository.getRates(pairs = pairs) }
}