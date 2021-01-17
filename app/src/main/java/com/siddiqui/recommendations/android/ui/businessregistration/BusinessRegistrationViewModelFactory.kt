package com.siddiqui.recommendations.android.ui.businessregistration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class BusinessRegistrationViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BusinessRegistrationViewModel::class.java)) {
            return BusinessRegistrationViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}