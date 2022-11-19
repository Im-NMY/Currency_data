package com.example.currency_data.mainscreen.data.network.exchangerateslist

interface RatesRepository {

    suspend fun getRates()
}