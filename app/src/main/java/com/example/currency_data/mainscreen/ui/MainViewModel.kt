package com.example.currency_data.mainscreen.ui

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.currency_data.base.BaseViewModel
import com.example.currency_data.base.Event
import com.example.currency_data.mainscreen.data.network.exchangerateslist.model.RatesRemoteModel
import com.example.currency_data.mainscreen.domain.CurrencyListModel
import com.example.currency_data.mainscreen.domain.Interactor
import kotlinx.coroutines.launch

class MainViewModel(private val interactor: Interactor) : BaseViewModel<ViewState>() {

    init {
        processDataEvent(DataEvent.LoadCurrency)
    }

    override fun initialViewState() = ViewState(
        currency = emptyList(),
        rates = RatesRemoteModel(
            rates = emptyList()
        )
    )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is DataEvent.LoadCurrency -> {
                viewModelScope.launch {
                    interactor.getCurrencyList().fold(
                        onError = {
                            Log.e("Error", it.localizedMessage)
                        },
                        onSuccess = {
                            processDataEvent(DataEvent.OnLoadCurrencySucceed(it))
                        })
                }
                return null
            }
            is DataEvent.OnLoadCurrencySucceed -> {
                previousState.copy(
                    currency = event.currency
                )
                viewModelScope.launch {
                    interactor.getRatesList(event.currency.joinToString(",")).fold(
                        onError = {
                            Log.e("Error", it.localizedMessage)
                        },
                        onSuccess = {
                            processDataEvent(DataEvent.OnLoadRatesSucceed(it))
                        })

                }
                return null
            }
            is DataEvent.OnLoadRatesSucceed -> {
                return previousState.copy(
                    rates = event.rates
                )
            }
            else -> return null
        }
    }


}