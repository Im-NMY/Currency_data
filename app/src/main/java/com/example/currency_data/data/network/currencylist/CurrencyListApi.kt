package com.example.currency_data.data.network.currencylist

import com.example.currency_data.data.network.currencylist.model.RatesRemoteModel
import com.example.currency_data.di.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyListApi {

    @GET("api/")
    suspend fun getCurrencyList(
        @Query("get") rates: String = "rates",
        @Query("pairs") pairs: String,
        @Query("key") key: String = API_KEY
    ): RatesRemoteModel
}