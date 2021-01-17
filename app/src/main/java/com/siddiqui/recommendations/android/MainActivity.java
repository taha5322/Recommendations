package com.siddiqui.recommendations.android;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.siddiqui.recommendations.R;
import com.siddiqui.recommendations.ui.Industry;
import com.siddiqui.recommendations.ui.ServicesAdapter;
import com.siddiqui.recommendations.database.DatabaseBuilder;
import com.siddiqui.recommendations.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import com.siddiqui.recommendations.ui.Industry;
import com.siddiqui.recommendations.ui.ServicesAdapter;
import com.siddiqui.recommendations.database.DatabaseBuilder;
import com.siddiqui.recommendations.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private DatabaseBuilder mBuilder;
  
    private ServicesAdapter adapter;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        adapter = new ServicesAdapter(this,getServices());

        binding.businesses.setAdapter(adapter);
        binding.businesses.setLayoutManager(new LinearLayoutManager(this));

        //Initialise database builder
        mBuilder = new DatabaseBuilder(MainActivity.this);

        //Fetching data example
//        MutableLiveData<String> data = mBuilder.fetchData("Business","Barbers",
//                "Magicuts","Magicuts");
//        data.observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                System.out.println("main ativity"+s);
//            }
//        });
    }

    private List<Industry> getServices(){
        List<Industry> services = new ArrayList<>();
        Industry service1 = new Industry("Barbershops","Places to get those beautiful hair cut");
        services.add(service1);
        service1 = new Industry("Restaurants","Everyone loves food");
        services.add(service1);
        service1 = new Industry("Mechanics","Your car wouldn't mind one");
        services.add(service1);
        service1 = new Industry("Key cutter","LOL");
        services.add(service1);
        return services;
    }

}
