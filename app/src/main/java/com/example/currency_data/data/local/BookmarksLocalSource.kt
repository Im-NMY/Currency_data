package com.example.currency_data.data.local

import com.example.currency_data.data.local.model.BookmarkEntity

class BookmarksLocalSource(private val bookmarksDao: BookmarksDao) {

    suspend fun create(entity: BookmarkEntity){
        bookmarksDao.create(entity)
    }
    suspend fun read(): List<BookmarkEntity>{
       return bookmarksDao.read()
    }
    suspend fun update(entity: BookmarkEntity){
        bookmarksDao.update(entity)
    }
    suspend fun delete(entity: BookmarkEntity){
        bookmarksDao.delete(entity)
    }
}