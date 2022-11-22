package com.example.currency_data.data.network.rateslist.model

import com.google.gson.annotations.SerializedName

data class CurrencyListRemoteModel(
    @SerializedName("data")
    val data: List<String>

)

