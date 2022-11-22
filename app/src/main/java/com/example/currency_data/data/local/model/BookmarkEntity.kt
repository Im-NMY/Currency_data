package com.example.currency_data.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.currency_data.di.BOOKMARKS_TABLE

@Entity(tableName = BOOKMARKS_TABLE)
data class BookmarkEntity (

    @PrimaryKey
    @ColumnInfo(name = "currency")
    val currency: String,
    @ColumnInfo(name = "value")
    val value: String
)