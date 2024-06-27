package com.example.sampleproject.views.activities

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleproject.JobDetailsFragment
import com.example.sampleproject.R
import com.example.sampleproject.RecyclerViewCardFragment
import com.example.sampleproject.UserCardFragment
import com.example.sampleproject.interfaces.OnItemClickListener
import com.example.sampleproject.interfaces.OnRecyclerCardClick
import java.io.Serializable

class RecyclerViewActivity : AppCompatActivity(), OnRecyclerCardClick, Serializable {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view)

        val username = intent.getStringExtra("EXTRA_USERNAME").toString()
        // Add User Card Fragment
        val bundle =  Bundle();
        bundle.putString("userName",username)

        val userCardFragments = UserCardFragment()
        userCardFragments.arguments=bundle

        val userCardFT = fragmentManager.beginTransaction()
        userCardFT.add(R.id.userCard, userCardFragments)
        userCardFT.addToBackStack(null)
        userCardFT.commit()

        // Add Recycler View Card Fragment
        val recyclerFragBundle = Bundle()
        val recyclerViewCardFragment = RecyclerViewCardFragment()
        recyclerViewCardFragment.arguments = recyclerFragBundle

        val recycleViewCardFT = fragmentManager.beginTransaction()
        recycleViewCardFT.add(R.id.recyclerViewCard, recyclerViewCardFragment)
        recycleViewCardFT.commit()
    }

    override fun onCardClickListener(jobDetailsData: JobDetailsData) {
        val bundle = Bundle()
        bundle.putString("tvTittle", jobDetailsData.tvTittle)
        bundle.putString("tvCompany", jobDetailsData.tvCompany)
        bundle.putString("salary", jobDetailsData.salary)

        val jobDetails = JobDetailsFragment()
        jobDetails.arguments = bundle

        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.recyclerViewCard, jobDetails)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }


}