package com.siddiqui.recommendations.android;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.siddiqui.recommendations.R;
import com.siddiqui.recommendations.database.DatabaseBuilder;

public class MainActivity extends AppCompatActivity {

    private DatabaseBuilder mBuilder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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




}