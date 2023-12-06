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
            return oldItem == newItem
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
        holder.bind(item)
    }

    private var onItemClickListener: ((Product) -> Unit)? = null

    fun setOnItemClickListener(listener: (Product) -> Unit) {
        onItemClickListener = listener
    }


    inner class CatalogViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val itemImage = itemView.findViewById<ImageView>(R.id.itemImage)
        private val itemName = itemView.findViewById<TextView>(R.id.itemName)
        private val itemDepartment = itemView.findViewById<TextView>(R.id.itemDepartment)
        private val itemPrice = itemView.findViewById<TextView>(R.id.itemPrice)
        fun bind(item: Product){
            itemView.apply {
                Glide.with(this).load(item.images[0]).into(itemImage)
                itemName.text = item.title
                itemDepartment.text = item.department
                itemPrice.text = resources.getString(R.string.product_price, item.price)

                setOnItemClickListener {
                    onItemClickListener?.let { it(item) }
                }
            }
        }
    }
}