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

class BusinessListAdapter() : ListAdapter<Business, BusinessListAdapter.ViewHolder>(ItemDiffCallback()) {


    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val name: TextView
        val address: TextView
//        val id: Long
        init {
            name = view.findViewById(R.id.business_name)
            address = view.findViewById(R.id.busniness_address)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.business_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = getItem(position).name
        holder.address.text = getItem(position).address
    }

}

class ItemDiffCallback: DiffUtil.ItemCallback<Business>() {
    override fun areItemsTheSame(oldItem: Business, newItem: Business): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Business, newItem: Business): Boolean {
        return oldItem.equals(newItem)
    }

}