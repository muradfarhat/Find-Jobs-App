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

        // Add User Card Fragment
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.userCard, UserCardFragment())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()

        // Add Recycler View Card Fragment
        fragmentTransaction.add(R.id.recyclerViewCard, RecyclerViewCardFragment())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}