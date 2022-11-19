package com.example.currency_data.mainscreen.data.network.rateslist.model

import com.example.currency_data.base.Item
import com.google.gson.annotations.SerializedName

data class CurrencyListRemoteModel(
    @SerializedName("data")
    val data: List<String>

)

