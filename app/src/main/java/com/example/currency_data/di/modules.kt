package com.example.currency_data.di

import android.util.Log
import androidx.room.Room
import com.example.currency_data.app.AppDatabase
import com.example.currency_data.data.local.BookmarksLocalSource
import com.example.currency_data.data.local.BookmarksRepository
import com.example.currency_data.data.local.BookmarksRepositoryImpl
import com.example.currency_data.data.network.RatesRepository
import com.example.currency_data.data.network.RatesRepositoryImpl
import com.example.currency_data.data.network.currencylist.CurrencyListApi
import com.example.currency_data.data.network.currencylist.RatesRemoteSource
import com.example.currency_data.data.network.rateslist.CurrencyApi
import com.example.currency_data.data.network.rateslist.CurrencyRemoteSource
import com.example.currency_data.domain.Interactor
import com.example.currency_data.ui.MainViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://currate.ru/"
const val API_KEY = "5dabcf7bc5a3864b0ce1f93c493d494c"
const val BOOKMARKS_TABLE = "BOOKMARKS_TABLE"
const val APP_DATABASE = "APP_DATABASE"

val networkModule = module {

    single<OkHttpClient> {
        OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor { massage ->
                Log.d("OkHttp", massage)
            }.apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }
        )
            .build()
    }
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get<OkHttpClient>())
            .build()
    }
}

val databaseModule = module {

    single {
        Room
            .databaseBuilder(androidContext(), AppDatabase::class.java, APP_DATABASE)
            .fallbackToDestructiveMigration()
            .build()
    }

    single {
        get<AppDatabase>().bookmarksDao()
    }
}

val bookmarksModule = module {

    single {
        BookmarksLocalSource(bookmarksDao = get())
    }

    single<BookmarksRepository> {
        BookmarksRepositoryImpl(source = get())
    }

    single<Interactor> {
        Interactor(ratesRepository = get(), localRepository = get())
    }

    viewModel {
        MainViewModel(interactor = get())
    }
}

val mainScreenModule = module {

    single<CurrencyApi> {
        get<Retrofit>().create(CurrencyApi::class.java)
    }
    single<CurrencyListApi> {
        get<Retrofit>().create(CurrencyListApi::class.java)
    }

    single<CurrencyRemoteSource> {
        CurrencyRemoteSource(api = get())
    }

    single<RatesRemoteSource> {
        RatesRemoteSource(api = get())
    }

    single<RatesRepository> {
        RatesRepositoryImpl(ratesSource = get(), source = get())
    }

    single<Interactor> {
        Interactor(ratesRepository = get(), localRepository = get())
    }
    viewModel {
        MainViewModel(interactor = get())
    }
}