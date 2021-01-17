package com.siddiqui.recommendations.ui;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.siddiqui.recommendations.R;
import com.siddiqui.recommendations.android.ui.businessdetail.BusinessDetailActivity;
import com.siddiqui.recommendations.android.ui.businesslist.BusinessListActivity;
import com.siddiqui.recommendations.databinding.IndustryListItemBinding;
import java.util.List;

// Created by Taha Siddiqui
// 16/01/21
public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.ViewHolder>{

    private Context context;
    private List<com.siddiqui.recommendations.ui.Industry> industries;
    IndustryListItemBinding binding;

    public ServicesAdapter(Context context,List<com.siddiqui.recommendations.ui.Industry> services){
        this.context = context;

        industries = services;
    }

    @NonNull
    @Override
    public ServicesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.industry_list_item,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(@NonNull ServicesAdapter.ViewHolder holder, int position) {
        Log.e("Error","This is the number" + position);
        com.siddiqui.recommendations.ui.Industry industry = industries.get(position);

        if(holder == null){
            Log.e("HOLDER IS NULL", "HOLDER IS NULL");
        }
        if(industry==null){
            Log.e("HOUR IS NULL", "HOUR IS NULL");
        }
        if(holder.industryListItemBinding == null){
            Log.e("ITEM BINDING IS EMPTY", "ITEM BINDING EMPTY");
        }
        Industry currentIndustry = industries.get(position);
        holder.industryListItemBinding.setIndustry(industry);

        holder.industryListItemBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return industries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public IndustryListItemBinding industryListItemBinding;
        public int pos;

        public void setPos(int i){
            pos = i;
        }

        public ViewHolder(@NonNull IndustryListItemBinding itemView) {

            super(itemView.getRoot());
            industryListItemBinding=itemView;

            industryListItemBinding.activeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Industry currentInd = industries.get(getAdapterPosition());
                    Intent intent = new Intent(context, BusinessListActivity.class);
                    intent.putExtra("Industry", currentInd.getName());
                    context.startActivity(intent);
                }
            });

        }

        @Override
        public void onClick(View v) {
            System.out.println("This is the system ID"+v.getId());
        }
    }
}