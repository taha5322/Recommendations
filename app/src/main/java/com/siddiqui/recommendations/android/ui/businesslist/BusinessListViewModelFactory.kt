package com.siddiqui.recommendations.android.ui.businesslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.siddiqui.recommendations.database.DatabaseBuilder

@Suppress("UNCHECKED_CAST")
class BusinessListViewModelFactory(val databaseBuilder: DatabaseBuilder, val category: String): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BusinessListViewModel::class.java)) {
            return BusinessListViewModel(databaseBuilder, category) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}