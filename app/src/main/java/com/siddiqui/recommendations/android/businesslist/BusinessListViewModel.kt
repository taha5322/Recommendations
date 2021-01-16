package com.siddiqui.recommendations.android.businesslist

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
                Business("Tom's Burgers", "123 Main st", 1L),
                Business("Bean Cafe", "456 Yonge st", 2L),
                Business("Mary's Supermarket", "789 King st", 3L),
                Business("Bob's Auto Shop", "237 Bear st", 4L)
        )
    }

}