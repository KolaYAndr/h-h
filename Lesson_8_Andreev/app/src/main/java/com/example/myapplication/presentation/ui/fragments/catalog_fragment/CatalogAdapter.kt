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

    private val differ = AsyncListDiffer(this, callback)

    fun submitList(products: List<Product>) {
        differ.submitList(products)
        notifyItemRangeChanged(0, products.size)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        return CatalogViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_product_view, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        val product = differ.currentList[position]
        holder.bind(product)
    }

    private var onItemClickListener: ((Product) -> Unit)? = null

    fun setOnItemClickListener(listener: (Product) -> Unit) {
        onItemClickListener = listener
    }

    inner class CatalogViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val productImage = itemView.findViewById<ImageView>(R.id.productImage)
        private val productName = itemView.findViewById<TextView>(R.id.productName)
        private val productDepartment = itemView.findViewById<TextView>(R.id.productDepartment)
        private val productPrice = itemView.findViewById<TextView>(R.id.productPrice)
        fun bind(product: Product) {
            itemView.apply {
                Glide.with(this).load(product.images[0]).into(productImage)
                productName.text = product.title
                productDepartment.text = product.department
                productPrice.text = String.format("%s ₽", product.price)

                setOnClickListener {
                    onItemClickListener?.let { it(product) }
                }
            }
        }
    }
}
