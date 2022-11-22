package com.example.currency_data.data.network.rateslist

import com.example.currency_data.data.network.rateslist.model.CurrencyListRemoteModel
import com.example.currency_data.di.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query


interface CurrencyApi {

    @GET("api/")
    suspend fun getListCurrency(
        @Query("get") currencyList: String = "currency_list",
        @Query("key") key: String = API_KEY
    ): CurrencyListRemoteModel
}

