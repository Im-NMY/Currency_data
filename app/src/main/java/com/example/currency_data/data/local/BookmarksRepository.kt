package com.example.currency_data.data.local

import com.example.currency_data.domain.ItemModel

interface BookmarksRepository {

    suspend fun create(model: ItemModel)

    suspend fun read(): List<ItemModel>

    suspend fun update(model: ItemModel)

    suspend fun delete(model: ItemModel)
}