package com.example.sampleproject.interfaces

import com.example.sampleproject.views.activities.JobDetailsData

interface OnRecyclerCardClick {
    fun onCardClickListener(jobDetailsData: JobDetailsData)
}