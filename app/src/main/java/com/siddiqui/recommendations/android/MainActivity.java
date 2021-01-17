package com.siddiqui.recommendations.android;

import android.content.Intent;
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
import androidx.recyclerview.widget.LinearLayoutManager;

import com.siddiqui.recommendations.R;
import com.siddiqui.recommendations.android.ui.BusinessRegistrationActivity;
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
    private Button regestrationButton;

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
        regestrationButton = findViewById(R.id.businessRegestration);
        regestrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BusinessRegistrationActivity.class);
                startActivity(intent);

            }
        });

    }

    private List<Industry> getServices(){
        List<Industry> services = new ArrayList<>();

        Industry service1 = new Industry("Barbershops","Places to get those beautiful hair cut",R.mipmap.barber);
        services.add(service1);
        service1 = new Industry("Restaurants","A wide range of cuisines at your fingertips",R.mipmap.rest);
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
    }

}
