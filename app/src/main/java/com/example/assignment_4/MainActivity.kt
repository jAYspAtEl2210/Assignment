package com.example.assignment_4

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)

        // Button 1 Click Listener: Increment counter and update TextView
        button1.setOnClickListener {
            counter++
            textView.text = "Button clicked $counter times"
        }

        // Button 2 Click Listener: Change TextView height
        button2.setOnClickListener {
            val newHeight = 200 // in pixels
            textView.layoutParams.height = newHeight
            textView.requestLayout()
        }

        // Button 3 Click Listener: Center text on the screen
        button3.setOnClickListener {
            val params = textView.layoutParams as RelativeLayout.LayoutParams
            params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE)
            textView.layoutParams = params
            textView.gravity = Gravity.CENTER
        }
    }
}