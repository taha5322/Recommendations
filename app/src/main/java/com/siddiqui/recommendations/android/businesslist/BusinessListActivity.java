package com.siddiqui.recommendations.android.businesslist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.siddiqui.recommendations.R;
import com.siddiqui.recommendations.android.Business;

import java.util.List;

public class BusinessListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_list);

        BusinessListViewModel viewModel = new ViewModelProvider(this, new BusinessListViewModelFactory())
                .get(BusinessListViewModel.class);

        RecyclerView recyclerView = findViewById(R.id.business_list_recycler_view);
        final BusinessListAdapter adapter = new BusinessListAdapter();
        viewModel.getBusinessList().observe(this, new Observer<List<Business>>() {
            @Override
            public void onChanged(List<Business> list) {
                adapter.submitList(list);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }
}