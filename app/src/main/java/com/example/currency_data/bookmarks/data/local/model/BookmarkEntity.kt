package com.example.currency_data.bookmarks.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.currency_data.bookmarks.di.BOOKMARKS_TABLE

@Entity(tableName = BOOKMARKS_TABLE)
data class BookmarkEntity (

    @PrimaryKey
    @ColumnInfo(name = "name")
    val name: String,

//    TODO

)