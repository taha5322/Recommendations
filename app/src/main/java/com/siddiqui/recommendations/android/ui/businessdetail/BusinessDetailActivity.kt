package com.siddiqui.recommendations.android.ui.businessdetail

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.siddiqui.recommendations.R
import com.siddiqui.recommendations.database.DatabaseBuilder

class BusinessDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_business_detail)

        val businessId = intent.getStringExtra("Business id")
        Log.d(TAG, "Business id: $businessId")

        val name: TextView = findViewById(R.id.business_detail_name)
        val address: TextView = findViewById(R.id.business_detail_address)

        // set toolbar title and up button

        // set toolbar title and up button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Tom's Burgers"

//        val databaseBuilder = DatabaseBuilder(this)
//        databaseBuilder.

    }

    companion object {
        private const val TAG = "BusinessDetailActivity"
    }

}