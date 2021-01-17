package com.siddiqui.recommendations.android.ui.businesslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.siddiqui.recommendations.android.Business
import com.siddiqui.recommendations.databinding.BusinessListItemBinding

class BusinessListAdapter(private val clickListener: BusinessListItemListener) : ListAdapter<Business, BusinessListAdapter.ViewHolder>(ItemDiffCallback()) {


    class ViewHolder private constructor(private val binding: BusinessListItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(business: Business, clickListener: BusinessListItemListener) {
            binding.business = business
            binding.clickListener = clickListener
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = BusinessListItemBinding.inflate(inflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }

}

open class BusinessListItemListener(val clickListener: (id: Long) -> Unit) {
    open fun onClick(business: Business) = clickListener(business.id)
}

class ItemDiffCallback: DiffUtil.ItemCallback<Business>() {
    override fun areItemsTheSame(oldItem: Business, newItem: Business): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Business, newItem: Business): Boolean {
        return oldItem.equals(newItem)
    }

}