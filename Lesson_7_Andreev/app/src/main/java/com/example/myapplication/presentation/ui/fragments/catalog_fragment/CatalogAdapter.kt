package com.example.myapplication.presentation.ui.fragments.catalog_fragment

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.product.Product

class CatalogAdapter : RecyclerView.Adapter<CatalogAdapter.CatalogViewHolder>() {
    private val callback = object : DiffUtil.ItemCallback<Product>(){
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.title == newItem.title
        }
    }

    val differ = AsyncListDiffer(this, callback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


    inner class CatalogViewHolder(view: View) : RecyclerView.ViewHolder(view)
}