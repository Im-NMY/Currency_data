package com.example.currency_data.data.network.currencylist.model

import com.google.gson.annotations.SerializedName

data class RatesRemoteModel(
    @SerializedName("data")
    val rates: Map<String, String>
)
