package com.example.assignment_3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment_3.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSend: Button = findViewById(R.id.btn_send)

        btnSend.setOnClickListener {
            // Create an Intent to move to SecondActivity
            val intent = Intent(this, SecondActivity::class.java)

            // Pass data using key-value pairs
            intent.putExtra("string1", getString(R.string.string1))
            intent.putExtra("string2", getString(R.string.string2))
            intent.putExtra("string3", getString(R.string.string3))
            intent.putExtra("string4", getString(R.string.string4))
            intent.putExtra("string5", getString(R.string.string5))

            intent.putExtra("booleanValue", true)
            intent.putExtra("integerValue", 123)
            intent.putExtra("floatValue", 45.67f)

            startActivity(intent) // Start SecondActivity
        }
    }
}