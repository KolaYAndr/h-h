package com.example.myapplication.presentation.ui.fragments.detail_fragment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.utils.DEFAULT_SIZE

class DetailViewPagerAdapter :
    RecyclerView.Adapter<DetailViewPagerAdapter.DetailViewPagerHolder>() {
    private val callback = object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, callback)

    fun submitList(images: List<String>) {
        val size = images.size
        val copy = images.toMutableList()
        for (i in size..<DEFAULT_SIZE) copy.add(images[0])
        differ.submitList(copy)
        notifyItemRangeChanged(0, DEFAULT_SIZE)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewPagerHolder {
        return DetailViewPagerHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_product_viewpager_image, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: DetailViewPagerHolder, position: Int) {
        val imageUrl = differ.currentList[position]
        holder.bind(imageUrl)
    }



    inner class DetailViewPagerHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(imageUrl: String) {
            val imageView: ImageView = itemView.findViewById(R.id.detailViewPagerImage)
            Glide.with(itemView)
                .load(imageUrl)
                .into(imageView)
        }
    }
}