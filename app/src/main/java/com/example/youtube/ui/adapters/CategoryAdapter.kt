package com.example.youtube.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.youtube.data.models.category.VideoCategoryModel
import com.example.youtube.databinding.ItemYoutubeBinding

class CategoryAdapter :
    ListAdapter<VideoCategoryModel, CategoryAdapter.AnimeViewHolder>(DiffUtilCallback()) {

    inner class AnimeViewHolder(private val binding: ItemYoutubeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: VideoCategoryModel) = with(binding) {
            Glide.with(binding.imageView.context)
                .load(item.snippet.thumbnails.high.url)
                .into(binding.imageView)
            Glide.with(binding.imageView2.context)
                .load(item.snippet.thumbnails.high.url)
                .into(binding.imageView2)
            binding.name.text = item.snippet.localized.description
            binding.pushingAt.text = item.snippet.localized.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        return AnimeViewHolder(
            ItemYoutubeBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {

        class DiffUtilCallback : DiffUtil.ItemCallback<VideoCategoryModel>() {

            override fun areItemsTheSame(oldItem: VideoCategoryModel, newItem: VideoCategoryModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: VideoCategoryModel, newItem: VideoCategoryModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}
