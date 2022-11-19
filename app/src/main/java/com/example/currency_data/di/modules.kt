package com.example.currency_data.di

import android.util.Log
import androidx.room.Room
import com.example.currency_data.app.AppDatabase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


const val APP_DATABASE = "APP_DATABASE"

val networkModule = module {

    val single = single<OkHttpClient> {
        OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor { massage ->
                Log.d("OkHttp", massage)
            }.apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }
        )
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