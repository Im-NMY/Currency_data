package com.example.currency_data.domain

import com.example.currency_data.base.Either
import com.example.currency_data.base.attempt
import com.example.currency_data.data.local.BookmarksRepository
import com.example.currency_data.data.network.RatesRepository

class Interactor(
    private val ratesRepository: RatesRepository,
    private val localRepository: BookmarksRepository
) {

    suspend fun getCurrencyList() = attempt { ratesRepository.getCurrencyList() }

    suspend fun getRatesList(pairs: String) = attempt { ratesRepository.getRates(pairs = pairs) }

    suspend fun create(model: ItemModel) {
        attempt { localRepository.create(model) }
    }

    suspend fun read(): Either<Throwable, List<ItemModel>> {
        return attempt { localRepository.read() }
    }

    suspend fun update(model: ItemModel) {
        attempt { localRepository.update(model) }
    }

    suspend fun delete(model: ItemModel) {
        attempt { localRepository.delete(model) }
    }

}