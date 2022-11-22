package com.example.currency_data.ui

import androidx.lifecycle.viewModelScope
import com.example.currency_data.base.BaseViewModel
import com.example.currency_data.base.Event
import com.example.currency_data.domain.Interactor
import kotlinx.coroutines.launch

class MainViewModel(
    private val interactor: Interactor
) : BaseViewModel<ViewState>() {

    init {
        processDataEvent(DataEvent.LoadCurrency)
        processDataEvent(DataEvent.LoadBookmarks)
    }

    override fun initialViewState() = ViewState(
        itemList = emptyList(),
        favoritesItemList = emptyList(),
        showItemList = emptyList(),
        isFilterShow = false,
        editText = "",
        isSearchEnable = false
    )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is DataEvent.LoadCurrency -> {
                viewModelScope.launch {
                    interactor.getCurrencyList().fold(
                        onError = {},
                        onSuccess = {
                            processDataEvent(DataEvent.OnLoadCurrencySucceed(it))
                        })
                }
                return null
            }

            is DataEvent.OnLoadCurrencySucceed -> {
                viewModelScope.launch {
                    interactor.getRatesList(event.currency.joinToString(",")).fold(
                        onError = {},
                        onSuccess = {
                            processDataEvent(DataEvent.OnLoadItemListSucceed(it.list))
                        })
                }
                return null
            }

            is DataEvent.LoadBookmarks -> {
                viewModelScope.launch {
                    interactor.read().fold(
                        onError = {},
                        onSuccess = {
                            processDataEvent(DataEvent.OnSuccessBookmarksLoaded(it))
                        }
                    )
                }
                return null
            }

            is DataEvent.OnSuccessBookmarksLoaded -> {
                return previousState.copy(favoritesItemList = event.favoritesItemList)
            }

            is DataEvent.OnLoadItemListSucceed -> {
                return previousState.copy(
                    itemList = event.itemList,
                    showItemList = event.itemList
                )
            }

            is UiEvent.OnDeleteItemClicked -> {
                viewModelScope.launch {
                    previousState.itemList[event.index].flag = false
                    interactor.delete(previousState.favoritesItemList[event.index])
                    processUiEvent(DataEvent.LoadBookmarks)
                }
                return null
            }

            is UiEvent.OnSaveItemClicked -> {
                previousState.itemList[event.index].flag = true
                viewModelScope.launch {
                    interactor.create(previousState.showItemList[event.index])
                }
                return null
            }
            is UiEvent.OnFilterClicked -> {
                return previousState.copy(isFilterShow = !previousState.isFilterShow)
            }
            is UiEvent.OnSortTypeClickedItemList -> {
                when (event.index) {
                    2131230827 -> {
                        return previousState.copy(
                            showItemList = previousState.itemList.sortedBy { it.currency }
                        )
                    }
                    2131230828 -> {
                        return previousState.copy(
                            showItemList = previousState.itemList.sortedByDescending { it.currency }
                        )
                    }
                    2131230830 -> {
                        return previousState.copy(
                            showItemList = previousState.itemList.sortedBy { it.value.toFloat() }
                        )
                    }
                    2131230829 -> {
                        return previousState.copy(
                            showItemList = previousState.itemList.sortedByDescending { it.value.toFloat() }
                        )
                    }
                    else -> return null
                }
            }
            is UiEvent.OnSortTypeClickedFavoritesList -> {
                when (event.index) {
                    2131230827 -> {
                        return previousState.copy(
                            favoritesItemList = previousState.favoritesItemList.sortedBy { it.currency }
                        )
                    }
                    2131230828 -> {
                        return previousState.copy(
                            favoritesItemList = previousState.favoritesItemList.sortedByDescending { it.currency }
                        )
                    }
                    2131230830 -> {
                        return previousState.copy(
                            favoritesItemList = previousState.favoritesItemList.sortedBy { it.value.toFloat() }
                        )
                    }
                    2131230829 -> {
                        return previousState.copy(
                            favoritesItemList = previousState.favoritesItemList.sortedByDescending { it.value.toFloat() }
                        )
                    }
                    else -> return null
                }
            }
            is UiEvent.OnSearchButtonClicked -> {
                return previousState.copy(
                    showItemList = if (previousState.isSearchEnable && previousState.editText == "") previousState.itemList else previousState.showItemList,
                    isSearchEnable = !previousState.isSearchEnable
                )
            }
            is UiEvent.OnSearchEdit -> {
                previousState.editText = event.txt
                return previousState.copy(showItemList = previousState.itemList.filter {
                    it.currency.contains(event.txt)
                }, isSearchEnable = previousState.isSearchEnable)
            }
            else -> return null
        }
    }
}
