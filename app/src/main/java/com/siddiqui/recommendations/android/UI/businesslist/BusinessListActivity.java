package com.siddiqui.recommendations.android.UI.businesslist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.siddiqui.recommendations.R;
import com.siddiqui.recommendations.android.Business;
import com.siddiqui.recommendations.android.UI.businessdetail.BusinessDetailActivity;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public class BusinessListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_list);

        // get intent args
        final Intent intent = getIntent();
        String category = intent.getStringExtra("Category");

        final BusinessListViewModel viewModel = new ViewModelProvider(this, new BusinessListViewModelFactory())
                .get(BusinessListViewModel.class);

        // adapter click listener
        final BusinessListAdapter adapter = new BusinessListAdapter(new BusinessListItemListener() {
            @Override
            public void onClick(@NotNull Business business) {
                Intent detailIntent = new Intent(getApplicationContext(), BusinessDetailActivity.class);
                detailIntent.putExtra("Business id", business.getId().toString());
                startActivity(detailIntent);
            }
        });

        // observe changes to recyclerview list
        RecyclerView recyclerView = findViewById(R.id.business_list_recycler_view);
        viewModel.getBusinessList().observe(this, new Observer<List<Business>>() {
            @Override
            public void onChanged(List<Business> list) {
                adapter.submitList(list);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // set toolbar title and up button
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(category);


    }
}