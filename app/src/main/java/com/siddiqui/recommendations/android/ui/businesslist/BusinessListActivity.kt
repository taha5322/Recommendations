package com.siddiqui.recommendations.android.ui.businesslist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.siddiqui.recommendations.R
import com.siddiqui.recommendations.android.ui.businessdetail.BusinessDetailActivity
import com.siddiqui.recommendations.database.DatabaseBuilder

class BusinessListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_business_list)

        // get intent args
        val intent = intent
        val category = intent.getStringExtra("Category")

        // viewmodel
        val viewModel = ViewModelProvider(this,
                BusinessListViewModelFactory(DatabaseBuilder(this), category))
                .get(BusinessListViewModel::class.java)

        // adapter click listener
        val adapter = BusinessListAdapter(BusinessListItemListener { id ->
            val detailIntent = Intent(applicationContext, BusinessDetailActivity::class.java)
            detailIntent.putExtra("Business id", id.toString())
            startActivity(detailIntent)
        })

        // observe changes to recyclerview list
        val recyclerView = findViewById<RecyclerView>(R.id.business_list_recycler_view)
        viewModel.businessList.observe(this, { list -> adapter.submitList(list) })
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // set toolbar title and up button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = category
    }
}