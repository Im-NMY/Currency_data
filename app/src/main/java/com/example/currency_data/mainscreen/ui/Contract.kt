package com.example.currency_data.mainscreen.ui

import com.example.currency_data.base.Event
import com.example.currency_data.mainscreen.data.network.exchangerateslist.model.RatesRemoteModel
import com.example.currency_data.mainscreen.domain.CurrencyListModel
import com.example.currency_data.mainscreen.domain.ListItemModel

data class ViewState(
    val currency: List<String>,
    val rates: RatesRemoteModel
)

sealed class UiEvent : Event {
    data class OnArticleClicked(val index: Int) : UiEvent()
    data class OnSearchEdit(val txt: String) : UiEvent()
    object OnSearchButtonClicked : UiEvent()
}

sealed class DataEvent : Event {
    object LoadCurrency : DataEvent()
    data class OnLoadCurrencySucceed(val currency: List<String>) : DataEvent()
    data class OnLoadRatesSucceed(val rates: RatesRemoteModel) : DataEvent()

    data class OnLoadCurrencyListSucceed(val itemList: List<ListItemModel>) : DataEvent()

}