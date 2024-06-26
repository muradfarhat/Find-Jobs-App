package com.example.sampleproject.views.activities

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleproject.R
import com.example.sampleproject.interfaces.OnItemClickListener

class RecyclerViewActivity : AppCompatActivity(), OnItemClickListener {

    private val data = listOf(
        Item(
            "UI/UX Designer",
            "Elux Space, Malang",
            "Part-time",
            "Remote",
            "Junior level",
            "Your profile match this job",
            "Yesterday",
            "\$300 - 500/month"
        ),
        Item(
            "Product Designer",
            "Flip, Jakarta Barat",
            "Full-time",
            "On-site",
            "Senior level",
            "Your profile match this job",
            "Now",
            "\$12k - 20k/years"
        ),
        Item(
            "UI/UX Designer",
            "Elux Space, Malang",
            "Part-time",
            "Remote",
            "Junior level",
            "Your profile match this job",
            "Yesterday",
            "\$300 - 500/month"
        ),
        Item(
            "Product Designer",
            "Flip, Jakarta Barat",
            "Full-time",
            "On-site",
            "Senior level",
            "Your profile match this job",
            "Now",
            "\$12k - 20k/years"
        ),
        Item(
            "UI/UX Designer",
            "Elux Space, Malang",
            "Part-time",
            "Remote",
            "Junior level",
            "Your profile match this job",
            "Yesterday",
            "\$300 - 500/month"
        ),
        Item(
            "Product Designer",
            "Flip, Jakarta Barat",
            "Full-time",
            "On-site",
            "Senior level",
            "Your profile match this job",
            "Now",
            "\$12k - 20k/years"
        )
    )
    private lateinit var username: String
    private lateinit var usernameText: TextView
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view)

        username = intent.getStringExtra("EXTRA_USERNAME").toString()
        usernameText = findViewById(R.id.usernameText)
        usernameText.setText("Hi, $username")
//        usernameText.text = "Hi, $username"

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = JobItemAdapter(data, this)
        recyclerView.adapter = adapter
    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this, JobDetailsActivity::class.java)
        intent.putExtra("tvCompany", data[position].tvCompany)
        intent.putExtra("tvTittle", data[position].tvTitle)
        intent.putExtra("salary", data[position].salary)
        startActivity(intent)
    }
}