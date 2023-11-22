package com.example.myapplication.presentation.ui.fragments.catalog_fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.data.product.Product

class CatalogAdapter : RecyclerView.Adapter<CatalogAdapter.CatalogViewHolder>() {
    private val callback = object : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.images[0] == newItem.images[0]
        }
    }

    val differ = AsyncListDiffer(this, callback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        return CatalogViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        val item = differ.currentList[position]

        val itemImage = holder.itemView.findViewById<ImageView>(R.id.itemImage)
        val itemName = holder.itemView.findViewById<TextView>(R.id.itemName)
        val itemDepartment = holder.itemView.findViewById<TextView>(R.id.itemDepartment)
        val itemPrice = holder.itemView.findViewById<TextView>(R.id.itemPrice)

        holder.itemView.apply {
            Glide.with(this).load(item.images[0]).into(itemImage)
            itemName.text = item.title
            itemDepartment.text = item.department
            itemPrice.text = StringBuilder(item.price).append(" ₽")

            setOnItemClickListener {
                onItemClickListener?.let { it(item) }
            }
        }
    }

    private var onItemClickListener: ((Product) -> Unit)? = null

    fun setOnItemClickListener(listener: (Product) -> Unit) {
        onItemClickListener = listener
    }


    inner class CatalogViewHolder(view: View) : RecyclerView.ViewHolder(view)
}