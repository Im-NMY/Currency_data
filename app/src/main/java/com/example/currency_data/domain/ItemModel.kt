package com.example.currency_data.domain

import com.example.currency_data.base.Item

data class ItemModel(
    val currency: String,
    val value: String,
    var flag: Boolean = false
) : Item {
    override val itemId: Long = value.hashCode().toLong()
}
