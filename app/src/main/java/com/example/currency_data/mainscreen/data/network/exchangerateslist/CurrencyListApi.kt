package com.example.currency_data.mainscreen.data.network.exchangerateslist

import com.example.currency_data.mainscreen.data.network.exchangerateslist.model.RatesRemoteModel
import com.example.currency_data.mainscreen.data.network.rateslist.model.CurrencyListRemoteModel
import com.example.currency_data.mainscreen.di.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyListApi {

    @GET("api/")
    suspend fun getCurrencyList(
        @Query("get") rates: String = "rates",
        @Query("pairs") pairs: String ="BCHEUR,BCHGBP,BCHJPY",
        @Query("key") key: String = API_KEY
    ): RatesRemoteModel
}