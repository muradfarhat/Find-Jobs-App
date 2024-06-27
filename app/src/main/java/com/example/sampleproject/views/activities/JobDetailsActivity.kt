package com.example.sampleproject.views.activities

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sampleproject.JobDetailsFragment
import com.example.sampleproject.R
import java.net.URI
import java.net.URL

class JobDetailsActivity : AppCompatActivity() {

    private val intent = Intent()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_job_details2)

        val jobDetails = JobDetailsFragment()
        val bundle = Bundle()

        val tvTittle = intent.getStringExtra("tvTittle")
        bundle.putString("tvTittle", tvTittle)
        val tvCompany = intent.getStringExtra("tvCompany")
        bundle.putString("tvCompany", tvCompany)
        val tvSalary = intent.getStringExtra("tvSalary")
        bundle.putString("tvSalary", tvSalary)

        jobDetails.arguments = bundle

        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.jobDetailsView, jobDetails)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}