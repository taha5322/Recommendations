package com.siddiqui.recommendations.android.ui.businessregistration

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.siddiqui.recommendations.R
import com.siddiqui.recommendations.android.Business

class BusinessRegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_business_registration)

        // viewmodel
        val viewModel = ViewModelProvider(this, BusinessRegistrationViewModelFactory())
                .get(BusinessRegistrationViewModel::class.java)




      //  val business = Business(name.toString(), address.toString(), phone, discounts, 1L)

        // set toolbar title and up button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.registration)

    }
}