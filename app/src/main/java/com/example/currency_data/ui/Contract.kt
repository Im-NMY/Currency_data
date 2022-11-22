package com.example.currency_data.ui

import com.example.currency_data.base.Event
import com.example.currency_data.domain.ItemModel

data class ViewState(
    val itemList: List<ItemModel>,
    val showItemList: List<ItemModel>,
    val favoritesItemList: List<ItemModel>,
    val isFilterShow: Boolean,
    val isSearchEnable: Boolean,
    var editText: String?,
)

sealed class UiEvent : Event {
    data class OnSaveItemClicked(val index: Int) : UiEvent()
    data class OnDeleteItemClicked(val index: Int) : UiEvent()
    data class OnSortTypeClickedItemList(val index: Int) : UiEvent()
    data class OnSortTypeClickedFavoritesList(val index: Int) : UiEvent()
    data class OnSearchEdit(val txt: String) : UiEvent()
    object OnSearchButtonClicked : UiEvent()
    object OnFilterClicked : UiEvent()
}

sealed class DataEvent : Event {
    object LoadCurrency : DataEvent()
    data class OnLoadCurrencySucceed(val currency: List<String>) : DataEvent()
    data class OnLoadItemListSucceed(val itemList: List<ItemModel>) : DataEvent()

    object LoadBookmarks : DataEvent()
    data class OnSuccessBookmarksLoaded(val favoritesItemList: List<ItemModel>) : DataEvent()
}