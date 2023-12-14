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

class BottomSheetAdapter<T : Any> : RecyclerView.Adapter<BottomSheetAdapter<T>.BottomSheetViewHolder>() {
    private val callback = object : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, callback)

    fun submitList(items: List<T>) {
        differ.submitList(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomSheetViewHolder {
        return BottomSheetViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_text_view, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: BottomSheetViewHolder, position: Int) {
        val size = differ.currentList[position]
        holder.bind(size)
    }

    private var onItemClickListener: ((T) -> Unit)? = null

    fun setOnItemClickListener(listener: (T) -> Unit) {
        onItemClickListener = listener
    }

    inner class BottomSheetViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val itemText = itemView.findViewById<TextView>(R.id.itemSizeText)
        fun bind(item: T) {
            itemView.apply {
                itemText.text = item.toString()

                when (item){
                    is Size -> if (item.isAvailable) {
                        setOnClickListener {
                            onItemClickListener?.let { it(item) }
                        }
                    } else itemText.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                    else -> setOnClickListener {
                        onItemClickListener?.let { it(item) }
                    }
                }
            }
        }
    }
}