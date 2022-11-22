package com.example.currency_data.ui

import com.example.currency_data.base.BaseDiffUtilItemCallback
import com.example.currency_data.base.Item
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class MainAdapter(
    onClick: (Int) -> Unit
) : AsyncListDifferDelegationAdapter<Item>(BaseDiffUtilItemCallback()) {

    init {
        delegatesManager.addDelegate(MainDelegate.currencyDelegate(onClick = onClick))
    }
}