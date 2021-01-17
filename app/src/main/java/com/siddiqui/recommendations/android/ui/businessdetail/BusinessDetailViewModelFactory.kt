package com.siddiqui.recommendations.android.ui.businessdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class BusinessDetailViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BusinessDetailViewModel::class.java)) {
            return BusinessDetailViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}