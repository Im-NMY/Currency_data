package com.example.currency_data.mainscreen.data.network.exchangerateslist.model

import com.google.gson.annotations.SerializedName

data class RatesRemoteModel(
    @SerializedName("data")
    val rates: List<RateRemoteModel>
)
