package com.siddiqui.recommendations.android.ui.businessregistration

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.siddiqui.recommendations.R
import com.siddiqui.recommendations.android.Business
import com.siddiqui.recommendations.database.DatabaseBuilder

class BusinessRegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_business_registration)

        // viewmodel
        val viewModel = ViewModelProvider(this, BusinessRegistrationViewModelFactory())
                .get(BusinessRegistrationViewModel::class.java)

        val name: EditText = findViewById(R.id.registration_name)
        val address: EditText = findViewById(R.id.registration_address)
        val phoneNumber: EditText = findViewById(R.id.registration_phone_number)
        val discounts: EditText = findViewById(R.id.registration_discounts)
        val category: EditText = findViewById(R.id.registration_category)
        val button: Button = findViewById(R.id.registration_button)

        val business = Business(name.toString(), address.toString(), phoneNumber.toString(),
                discounts.toString())
        val databaseBuilder = DatabaseBuilder(this)

        button.setOnClickListener {
            databaseBuilder.addOrUpdateData("Business", category.toString(), business.name, business.name, business.address, business.phone)
//            Log.d(Companion.TAG, "Register clicked!")
            Toast.makeText(this, "Registration Complete!", Toast.LENGTH_SHORT).show()
        }


        //  val business = Business(name.toString(), address.toString(), phone, discounts, 1L)

        // set toolbar title and up button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.registration)

    }

    companion object {
        private const val TAG = "BusinessRegistrationAct"
    }
}