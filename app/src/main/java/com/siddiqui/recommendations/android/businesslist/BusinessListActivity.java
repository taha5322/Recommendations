package com.siddiqui.recommendations.android.businesslist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toolbar;

import com.siddiqui.recommendations.R;
import com.siddiqui.recommendations.android.Business;

import java.util.List;
import java.util.Objects;

public class BusinessListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_list);

        // get intent args
        Intent intent = getIntent();
        String category = intent.getStringExtra("Category");

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

        // set toolbar
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(category);


    }
}