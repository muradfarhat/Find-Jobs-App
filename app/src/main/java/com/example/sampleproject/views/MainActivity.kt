package com.example.sampleproject.views

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.WindowManager
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleproject.R
import com.example.sampleproject.util.CommonUtils
import com.example.sampleproject.views.activities.Item
import com.example.sampleproject.views.activities.JobItemAdapter
import com.example.sampleproject.views.activities.RecyclerViewActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = findViewById<EditText?>(R.id.userName)
        val password = findViewById<EditText?>(R.id.password)
        val loginBtn: TextView = findViewById(R.id.loginbtn)
        var intent: Intent

        loginBtn.setOnClickListener {
                if(username.text.isNotEmpty() && CommonUtils.isValidEmailFormat(username.text.toString()) && password.text.isNotEmpty()) {
                intent = Intent(this@MainActivity, RecyclerViewActivity::class.java)
                intent.putExtra("EXTRA_USERNAME", username.text.toString())
                startActivity(intent)
            } else {
                Toast.makeText(this@MainActivity,
                    getString(R.string.invalid_email_or_password), Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }


}

