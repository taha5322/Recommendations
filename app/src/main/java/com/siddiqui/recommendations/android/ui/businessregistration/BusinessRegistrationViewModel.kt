package com.siddiqui.recommendations.android.ui.businessregistration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.siddiqui.recommendations.android.Business

class BusinessRegistrationViewModel : ViewModel() {

    private var _registering = MutableLiveData<Business>()
    val registering: LiveData<Business>
        get() = _registering



    fun onRegistrationButtonClicked() {

    }

    fun onRegistrationComplete() {

    }

}