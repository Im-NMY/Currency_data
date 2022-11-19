package com.example.currency_data.mainscreen.di

import com.example.currency_data.mainscreen.data.network.exchangerateslist.CurrencyListApi
import com.example.currency_data.mainscreen.data.network.exchangerateslist.ExchangeRatesRemoteSource
import com.example.currency_data.mainscreen.data.network.exchangerateslist.RatesRepository
import com.example.currency_data.mainscreen.data.network.exchangerateslist.RatesRepositoryImpl
import com.example.currency_data.mainscreen.data.network.rateslist.CurrencyApi
import com.example.currency_data.mainscreen.data.network.rateslist.CurrencyRemoteSource
import com.example.currency_data.mainscreen.data.network.rateslist.CurrencyRepository
import com.example.currency_data.mainscreen.data.network.rateslist.CurrencyRepositoryImpl
import com.example.currency_data.mainscreen.domain.Interactor
import com.example.currency_data.mainscreen.ui.MainViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val BASE_URL = "https://currate.ru/"
const val API_KEY = "ec765c0c091a5b14f9fddab60a407333"

val mainScreenModule = module {

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get<OkHttpClient>())
            .build()
    }

    single<CurrencyApi> {
        get<Retrofit>().create(CurrencyApi::class.java)
    }
    single<CurrencyListApi> {
        get<Retrofit>().create(CurrencyListApi::class.java)
    }

    single<CurrencyRemoteSource> {
        CurrencyRemoteSource(api = get())
    }

    single<ExchangeRatesRemoteSource> {
        ExchangeRatesRemoteSource(api = get())
    }

    single<CurrencyRepository> {
        CurrencyRepositoryImpl(source = get())
    }
    single<RatesRepository> {
        RatesRepositoryImpl(ratesSource = get())
    }

    single<Interactor> {
        Interactor(currencyRepository = get(), ratesRepository = get())
    }
    viewModel {
        MainViewModel(interactor = get())
    }
}
