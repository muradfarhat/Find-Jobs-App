package com.example.sampleproject.views.activities

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleproject.R
import com.example.sampleproject.RecyclerViewCardFragment
import com.example.sampleproject.UserCardFragment
import com.example.sampleproject.interfaces.OnItemClickListener

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view)

        val username = intent.getStringExtra("EXTRA_USERNAME").toString()
        // Add User Card Fragment
        val bundle =  Bundle();
 bundle.putString("userName",username)

        val userFragments = UserCardFragment()
       userFragments.arguments=bundle

        val userCardFT = fragmentManager.beginTransaction()
        userCardFT.add(R.id.userCard, userFragments)
        userCardFT.addToBackStack(null)
        userCardFT.commit()

        // Add Recycler View Card Fragment
        val recycleViewCardFT = fragmentManager.beginTransaction()
        recycleViewCardFT.add(R.id.recyclerViewCard, RecyclerViewCardFragment())
        recycleViewCardFT.addToBackStack(null)
        recycleViewCardFT.commit()
    }
}