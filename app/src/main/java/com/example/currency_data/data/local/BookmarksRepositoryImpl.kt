package com.example.currency_data.data.local

import com.example.currency_data.domain.ItemModel

class BookmarksRepositoryImpl(private val source: BookmarksLocalSource): BookmarksRepository {
    override suspend fun create(model: ItemModel) {
        source.create(model.toEntity())
    }

    override suspend fun read(): List<ItemModel> {
        return source.read().map { it.toDomain() }
    }

    override suspend fun update(model: ItemModel) {
        source.update(model.toEntity())
    }

    override suspend fun delete(model: ItemModel) {
        source.delete(model.toEntity())
    }
}