package com.example.currency_data.app

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.currency_data.data.local.BookmarksDao
import com.example.currency_data.data.local.model.BookmarkEntity

@Database(entities = [BookmarkEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun bookmarksDao(): BookmarksDao
}