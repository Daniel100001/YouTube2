package com.example.youtube.ui.fragments

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.youtube.R
import com.example.youtube.base.BaseFragment
import com.example.youtube.databinding.FragmentYouTubeBinding
import com.example.youtube.ui.adapters.CategoryAdapter
import com.example.youtube.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class YouTubeFragment :
    BaseFragment<FragmentYouTubeBinding, YouTubeViewModel>(R.layout.fragment_you_tube) {

    override val binding by viewBinding(FragmentYouTubeBinding::bind)
    override val viewModel by viewModels<YouTubeViewModel>()
    private val categoryAdapter = CategoryAdapter()

    override fun initialize() {
        binding.recyclerviewYouTube.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = categoryAdapter
        }
    }

    override fun setupSubscribes() {
        viewModel.fetchVideoCategory().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    Log.e("dan", it.message.toString())
                }
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    categoryAdapter.submitList(it.data?.items)
                    Log.d("anime", it.data?.items.toString())
                }
            }
        }
    }
}