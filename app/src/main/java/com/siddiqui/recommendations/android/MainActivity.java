package com.siddiqui.recommendations.android;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.siddiqui.recommendations.R;
import com.siddiqui.recommendations.android.ui.businesslist.BusinessListActivity;
import com.siddiqui.recommendations.android.ui.businessregistration.BusinessRegistrationActivity;
import com.siddiqui.recommendations.database.DatabaseBuilder;
import com.siddiqui.recommendations.databinding.ActivityMainBinding;
import com.siddiqui.recommendations.ui.Industry;
import com.siddiqui.recommendations.ui.IndustryClickListener;
import com.siddiqui.recommendations.ui.ServicesAdapter;

import java.util.ArrayList;
import java.util.List;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;


public class MainActivity extends AppCompatActivity {

    private DatabaseBuilder mBuilder;

    private ServicesAdapter adapter;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        adapter = new ServicesAdapter(this, getServices(), new IndustryClickListener(new Function1<String, Unit>() {
            @Override
            public Unit invoke(String name) {
                // move to business list activity
                Log.d(TAG, "Industry Clicked name: " + name);
                Intent intent = new Intent(getApplicationContext(), BusinessListActivity.class);
                intent.putExtra("Category", name);
                startActivity(intent);
                return null;
            }
        }));

        binding.businesses.setAdapter(adapter);
        binding.businesses.setLayoutManager(new LinearLayoutManager(this));
        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BusinessRegistrationActivity.class);
                startActivity(intent);
            }
        });

        //Initialise database builder
        mBuilder = new DatabaseBuilder(MainActivity.this);

        //Fetching data example
//        MutableLiveData<String> data = mBuilder.fetchData("Business","Barbers",
//                "Magicuts","Magicuts");
//        data.observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                Log.d(TAG, "main ativity"+s);
//            }
//        });
//
//        mBuilder.addOrUpdateData("Business","Barbers",
//                "Magicuts","Magicuts", "test", "test 2");
    }

    private List<Industry> getServices() {
        List<Industry> services = new ArrayList<>();

        Industry service1 = new Industry("Restaurants", "Everyone loves food");
        services.add(service1);
        service1 = new Industry("Barbershops", "Places to get those beautiful hair cut");
        services.add(service1);
        service1 = new Industry("Mechanics", "Your car wouldn't mind one");
        services.add(service1);
        service1 = new Industry("Key cutter", "LOL");
        services.add(service1);
        return services;
//        return mBuilder
    }

    private static final String TAG = "MainActivity";

}
