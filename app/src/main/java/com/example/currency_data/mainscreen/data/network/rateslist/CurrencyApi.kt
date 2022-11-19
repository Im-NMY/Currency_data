package com.example.currency_data.mainscreen.data.network.rateslist

import com.example.currency_data.mainscreen.data.network.rateslist.model.CurrencyListRemoteModel
import com.example.currency_data.mainscreen.di.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query


interface CurrencyApi {

    @GET("api/")
    suspend fun getListCurrency(
        @Query("get") currencyList: String = "currency_list",
        @Query("key") key: String = API_KEY
    ): CurrencyListRemoteModel

//    @GET("api/")
//    suspend fun getResultListCurrency(
//        @Query("pairs") pairs: List<String> =
//        @Query("key") key: String = API_KEY
//    ): CurrencyResultListRemoteModel
}

//listOf("USDRUB","EURRUB","BCHRUB","BTCRUB","BYNRUB","CADRUB","CHFRUB", "CNYRUB","ETHRUB","GBPRUB",
//"GELRUB","JPYRUB","LKRRUB","MDLRUB","MMKRUB","RSDRUB","THBRUB","XRPRUB"),
