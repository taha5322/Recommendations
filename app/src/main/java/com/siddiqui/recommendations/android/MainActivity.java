package com.siddiqui.recommendations.android;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.siddiqui.recommendations.R;
import com.siddiqui.recommendations.android.businesslist.BusinessListActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message");
//        myRef.setValue("hello, world");
//
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                String value = snapshot.getValue(String.class);
//                Log.d("Tag","Value is "+value);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Log.w("TAG","Failed to read value",error.toException());
//            }
//        });

    }


    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = new Intent(this, BusinessListActivity.class);
        startActivity(intent);
    }
}
