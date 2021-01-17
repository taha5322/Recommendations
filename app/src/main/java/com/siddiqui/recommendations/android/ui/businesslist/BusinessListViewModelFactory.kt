package com.siddiqui.recommendations.android.ui.businesslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class BusinessListViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BusinessListViewModel::class.java)) {
            return BusinessListViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}