package com.siddiqui.recommendations.android.ui.businesslist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.siddiqui.recommendations.android.Business

class BusinessListViewModel: ViewModel() {

    private var _businessList = MutableLiveData<List<Business>>()
    val businessList: LiveData<List<Business>>
        get() = _businessList

    init {
        _businessList.value = listOf(
                Business("Tom's Burgers", "123 Main st", "456-812-4511", "Free fries with burger!", 1L),
                Business("Bean Cafe", "456 Yonge st", "487-996-1302", "None currently.", 2L),
                Business("Mary's Supermarket", "789 King st", "156-8778-5645", "Meats half price!", 3L),
                Business("Bob's Auto Shop", "237 Bear st", "759-756-7147", "25% off oil change until May 17th!", 4L)
        )
    }

    fun onClick(id: Long) {
        Log.d(TAG, "Clicked id: $id")
    }

    companion object {
        private const val TAG = "BusinessListViewModel"
    }

}