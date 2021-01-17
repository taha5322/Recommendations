package com.siddiqui.recommendations.ui

import com.siddiqui.recommendations.android.Business

class IndustryClickListener(val clickListener: (String) -> Unit) {
    fun onClick(industry: Industry) = clickListener(industry.name)
}