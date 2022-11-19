package com.example.currency_data.mainscreen.data.network.exchangerateslist.model

import com.google.gson.annotations.SerializedName

data class RateRemoteModel(
    @SerializedName("BCHEUR")
    val BCHEUR: String,
    @SerializedName("BCHGBP")
    val BCHGBP: String,
    @SerializedName("BCHJPY")
    val BCHJPY: String
)