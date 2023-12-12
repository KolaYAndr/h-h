package com.example.myapplication.presentation.ui.fragments.bottom_sheet_fragment

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.product.Size

class BottomSheetAdapter : RecyclerView.Adapter<BottomSheetAdapter.BottomSheetViewHolder>() {
    private val callback = object : DiffUtil.ItemCallback<Size>() {
        override fun areItemsTheSame(oldItem: Size, newItem: Size): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Size, newItem: Size): Boolean {
            return oldItem.value == newItem.value
        }
    }

    private val differ = AsyncListDiffer(this, callback)

    fun submitList(sizes: List<Size>) {
        differ.submitList(sizes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomSheetViewHolder {
        return BottomSheetViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_size_view, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: BottomSheetViewHolder, position: Int) {
        val size = differ.currentList[position]
        holder.bind(size)
    }

    private var onItemClickListener: ((Size) -> Unit)? = null

    fun setOnItemClickListener(listener: (Size) -> Unit) {
        onItemClickListener = listener
    }

    inner class BottomSheetViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val itemSizeText = itemView.findViewById<TextView>(R.id.itemSizeText)
        fun bind(size: Size) {
            itemView.apply {
                itemSizeText.text = size.value
                if (size.isAvailable) {
                    setOnClickListener {
                        onItemClickListener?.let { it(size) }
                    }
                } else itemSizeText.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            }
        }
    }
}