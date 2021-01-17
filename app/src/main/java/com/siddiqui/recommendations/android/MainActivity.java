package com.siddiqui.recommendations.android;

import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.siddiqui.recommendations.R;

import com.siddiqui.recommendations.android.ui.businesslist.BusinessListActivity;
import com.siddiqui.recommendations.android.ui.businessregistration.BusinessRegistrationActivity;

import com.siddiqui.recommendations.android.ui.BusinessRegistrationActivity;
import com.siddiqui.recommendations.ui.Industry;
import com.siddiqui.recommendations.ui.ServicesAdapter;

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
    private Button regestrationButton;

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


        Industry service1 = new Industry("Restaurants","A wide range of cuisines at your fingertips",R.mipmap.rest);
        services.add(service1);
        service1 = new Industry("Barbershops","Places to get those beautiful hair cut",R.mipmap.barber);
        services.add(service1);
        service1 = new Industry("Mechanics","Your car wouldn't mind one",R.mipmap.mechanic);
        services.add(service1);
        service1 = new Industry("Grocery Store","Who doesn't love doing them",R.mipmap.grocery);
        services.add(service1);
        service1 = new Industry("Thrift stores","Money is good; spend it wisely",R.mipmap.thrift);
        services.add(service1);
        service1 = new Industry("Bars","For those weekends after long weeks",R.mipmap.bars);
        services.add(service1);
        service1 = new Industry("Tutoring","Knowledge is the most powerful asset in this day and age",R.mipmap.tutoring);
        services.add(service1);
        service1 = new Industry("Misc","Misc",R.mipmap.ic_launcher_round);

        services.add(service1);
        return services;
//        return mBuilder
    }

    private static final String TAG = "MainActivity";


}
