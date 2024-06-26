package com.example.sampleproject.views.activities

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sampleproject.R
import java.net.URI
import java.net.URL

class JobDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_job_details2)

        val tvCompany = intent.getStringExtra("tvCompany").toString()
        val tvTittle = intent.getStringExtra("tvTittle").toString()
        val itemImage = intent.getStringExtra("itemImage").toString()
        val salaryValue = intent.getStringExtra("salary").toString()

        val companyName: TextView = findViewById(R.id.companyName)
        companyName.setText(tvCompany)

        val jobTittle: TextView = findViewById(R.id.positionName)
        jobTittle.setText(tvTittle)

        val salary: TextView = findViewById(R.id.salary)
        salary.setText(salaryValue)

//        val companyImage: ImageView = findViewById(R.id.companyImage)
//        companyImage.setImageURI(URI(itemImage))

        val btnBack: ImageButton = findViewById(R.id.btnBack)

        btnBack.setOnClickListener {
            onBackPressed()
        }
    }
}