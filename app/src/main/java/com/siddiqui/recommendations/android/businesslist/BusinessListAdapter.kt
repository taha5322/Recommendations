package com.siddiqui.recommendations.android.businesslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.siddiqui.recommendations.R
import com.siddiqui.recommendations.android.Business

class BusinessListAdapter(private val clickListener: BusinessListItemListener) : ListAdapter<Business, BusinessListAdapter.ViewHolder>(ItemDiffCallback()) {


    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private var id: Long = 0L
        private val name: TextView = view.findViewById(R.id.business_name)
        private val address: TextView = view.findViewById(R.id.business_address)
        private val clickable: View = view.findViewById(R.id.single_business_selectable_item)

        fun bind(business: Business, clickListener: BusinessListItemListener) {
            this.name.text = business.name
            this.address.text = business.address
            this.id = business.id
            clickable.setOnClickListener {
                clickListener.onClick(business)
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.business_list_item, parent, false)
                return ViewHolder(view)
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

interface BusinessListItemListener {
    fun onClick(business: Business)
}

class ItemDiffCallback: DiffUtil.ItemCallback<Business>() {
    override fun areItemsTheSame(oldItem: Business, newItem: Business): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Business, newItem: Business): Boolean {
        return oldItem.equals(newItem)
    }

}