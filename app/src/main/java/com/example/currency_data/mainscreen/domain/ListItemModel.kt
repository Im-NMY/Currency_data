package com.example.currency_data.mainscreen.domain

import com.example.currency_data.base.Item

data class ListItemModel(
    val value: String
): Item{
    override val itemId: Long = value.hashCode().toLong()
}
