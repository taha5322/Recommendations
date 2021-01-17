package com.siddiqui.recommendations.android.UI

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.siddiqui.recommendations.R
import com.siddiqui.recommendations.android.Business
import java.util.*

class BusinessRegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_business_registration)

        val name: EditText = findViewById(R.id.registration_name)
        val address: EditText = findViewById(R.id.registration_address)
        val phoneNumber: EditText = findViewById(R.id.registration_phone_number)
        val discounts: EditText = findViewById(R.id.registration_discounts)

        val business = Business(name.toString(), address.toString(), 1L)

        // set toolbar title and up button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.registration)

    }
}