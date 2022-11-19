package com.example.currency_data.mainscreen.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import com.example.currency_data.R
import com.example.currency_data.base.viewBinding
import com.example.currency_data.databinding.FragmentMainBinding
import com.example.currency_data.mainscreen.domain.CurrencyListModel
import com.example.currency_data.mainscreen.domain.ListItemModel
import com.example.currency_data.ui.MainAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewBinding { FragmentMainBinding.bind(it) }
    private val adapter = MainAdapter()
    private val viewModel: MainViewModel by viewModel<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner, ::render)
        binding.mainRecyclerView.adapter = adapter



    }
    private fun render(viewState: ViewState) {
        adapter.items = viewState.currency.map { ListItemModel(value = it) }
    }
}