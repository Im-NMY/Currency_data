package com.example.currency_data.data.local

import com.example.currency_data.data.local.model.BookmarkEntity
import com.example.currency_data.domain.ItemModel

fun BookmarkEntity.toDomain() = ItemModel(
    currency = currency,
    value = value
)

fun ItemModel.toEntity() = BookmarkEntity(
    currency = currency,
    value = value
)