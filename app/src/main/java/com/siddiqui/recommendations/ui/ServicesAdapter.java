package com.siddiqui.recommendations.ui;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.siddiqui.recommendations.R;
import com.siddiqui.recommendations.databinding.BusinessListItemBinding;

import java.util.List;

// Created by Taha Siddiqui
// 16/01/21
public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.ViewHolder>{

    private Context context;
    private List<Industry> industries;
    BusinessListItemBinding binding;

    public ServicesAdapter(Context context,List<Industry> services){
        this.context = context;

        industries = services;
    }

    @NonNull
    @Override
    public ServicesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.business_list_item,parent,false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ServicesAdapter.ViewHolder holder, int position) {
        Log.e("Error","This is the number" + position);
        Industry industry = industries.get(position);

        if(holder == null){
            Log.e("HOLDER IS NULL", "HOLDER IS NULL");
        }
        if(industry==null){
            Log.e("HOUR IS NULL", "HOUR IS NULL");
        }
        if(holder.businessListItemBinding == null){
            Log.e("ITEM BINDING IS EMPTY", "ITEM BINDING EMPTY");
        }
        holder.businessListItemBinding.setBusiness(industry);

    }

    @Override
    public int getItemCount() {
        return industries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public BusinessListItemBinding businessListItemBinding;

        public ViewHolder(@NonNull BusinessListItemBinding itemView) {
            super(itemView.getRoot());
            businessListItemBinding=itemView;
        }
    }
}