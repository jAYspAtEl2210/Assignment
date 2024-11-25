package com.example.assignment_3


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment_3.R
import com.example.assignment_3.ThirdActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val tvDisplay: TextView = findViewById(R.id.tv_display_data)
        val btnNext: Button = findViewById(R.id.btn_next)

        // Retrieve data from Intent
        val string1 = intent.getStringExtra("string1") ?: ""
        val string2 = intent.getStringExtra("string2") ?: ""
        val string3 = intent.getStringExtra("string3") ?: ""
        val string4 = intent.getStringExtra("string4") ?: ""
        val string5 = intent.getStringExtra("string5") ?: ""

        val booleanValue = intent.getBooleanExtra("booleanValue", false)
        val integerValue = intent.getIntExtra("integerValue", 0)
        val floatValue = intent.getFloatExtra("floatValue", 0.0f)

        // Combine data into a single string
        val combinedData = "$string1, $string2, $string3, $string4, $string5 | Bool: $booleanValue | Int: $integerValue | Float: $floatValue"

        // Display data in TextView
        tvDisplay.text = combinedData

        // Log the data
        Log.d("SecondActivity", combinedData)

        // Button to go to ThirdActivity
        btnNext.setOnClickListener {
            val nextIntent = Intent(this, ThirdActivity::class.java)
            nextIntent.putExtra("finalData", combinedData)
            startActivity(nextIntent)
        }
    }
}