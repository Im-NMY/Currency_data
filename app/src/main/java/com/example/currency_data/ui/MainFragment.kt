package com.example.currency_data.ui

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.currency_data.R
import com.example.currency_data.base.viewBinding
import com.example.currency_data.databinding.FragmentMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewBinding { FragmentMainBinding.bind(it) }
    private val viewModel: MainViewModel by viewModel<MainViewModel>()
    private val adapter = MainAdapter { index ->
        viewModel.processUiEvent(UiEvent.OnSaveItemClicked(index))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner, ::render)
        binding.mainRecyclerView.adapter = adapter


        binding.toolbar.btnSearch.setOnClickListener {
            viewModel.processUiEvent(UiEvent.OnSearchButtonClicked)
            binding.toolbar.etSearch.showKeyboard()
            binding.toolbar.etSearch.requestFocus()
        }

        binding.toolbar.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                text: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(
                text: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
            }

            override fun afterTextChanged(text: Editable?) {
                viewModel.processUiEvent(UiEvent.OnSearchEdit(text.toString()))
            }
        })

        binding.toolbar.btnFilter.setOnClickListener {
            viewModel.processUiEvent(UiEvent.OnFilterClicked)
        }

        binding.filter.radioGroup.setOnCheckedChangeListener { group, mainCheckedId ->
            viewModel.processUiEvent(UiEvent.OnSortTypeClickedItemList(mainCheckedId))
            Log.e("type", "$mainCheckedId")
        }

    }

    private fun render(viewState: ViewState) {
        binding.filter.cvFilter.visibility =
            if (viewState.isFilterShow) CardView.VISIBLE else CardView.GONE
        binding.toolbar.tvTitle.visibility =
            if (!viewState.isSearchEnable) TextView.VISIBLE else TextView.GONE
        binding.toolbar.etSearch.visibility =
            if (viewState.isSearchEnable) EditText.VISIBLE else EditText.GONE
        adapter.items = viewState.showItemList

    }

    private fun View.showKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }

    private fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}