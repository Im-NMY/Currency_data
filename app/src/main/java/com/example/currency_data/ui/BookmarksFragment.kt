package com.example.currency_data.ui

import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.currency_data.R
import com.example.currency_data.base.viewBinding
import com.example.currency_data.databinding.FragmentBookmarksBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookmarksFragment : Fragment(R.layout.fragment_bookmarks) {

    private val binding by viewBinding { FragmentBookmarksBinding.bind(it) }
    private val viewModel: MainViewModel by viewModel<MainViewModel>()
    private val adapter = MainAdapter { index ->
        viewModel.processUiEvent(UiEvent.OnDeleteItemClicked(index))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner, ::render)
        binding.bookmarksRecyclerView.adapter = adapter

        binding.toolbar.btnSearch.visibility = CardView.GONE
        binding.toolbar.tvTitle.text = "Избранное:"

        binding.toolbar.btnFilter.setOnClickListener {
            viewModel.processUiEvent(UiEvent.OnFilterClicked)
        }

        binding.filter.radioGroup.setOnCheckedChangeListener { group, secondCheckedId ->
            viewModel.processUiEvent(UiEvent.OnSortTypeClickedFavoritesList(secondCheckedId))
        }
    }

    private fun render(viewState: ViewState) {
        binding.filter.cvFilter.visibility =
            if (viewState.isFilterShow) CardView.VISIBLE else CardView.GONE
        adapter.items = viewState.favoritesItemList
    }
}