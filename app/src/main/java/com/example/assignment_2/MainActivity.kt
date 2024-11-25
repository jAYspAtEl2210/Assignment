package com.example.assignment_2

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment_2.R

class MainActivity : AppCompatActivity() {

    private lateinit var frameLayout: FrameLayout
    private lateinit var textView: TextView
    private lateinit var buttonChangeText: Button
    private lateinit var buttonCenterText: Button
    private lateinit var buttonLeft: Button
    private lateinit var buttonUp: Button
    private lateinit var buttonRight: Button
    private lateinit var buttonDown: Button

    private var clickCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the views
        frameLayout = findViewById(R.id.frameLayout)
        textView = findViewById(R.id.textView)
        buttonChangeText = findViewById(R.id.buttonChangeText)
        buttonCenterText = findViewById(R.id.buttonCenterText)
        buttonLeft = findViewById(R.id.buttonLeft)
        buttonUp = findViewById(R.id.buttonUp)
        buttonRight = findViewById(R.id.buttonRight)
        buttonDown = findViewById(R.id.buttonDown)

        // Set up listeners for the buttons
        buttonChangeText.setOnClickListener {
            // Change the text dynamically on each click
            clickCount++
            textView.text = "Clicked $clickCount times!"
        }

        buttonCenterText.setOnClickListener {
            // Center the TextView in the FrameLayout
            textView.x = (frameLayout.width - textView.width) / 2f
            textView.y = (frameLayout.height - textView.height) / 2f
        }

        buttonLeft.setOnClickListener {
            // Move the text left with animation
            val targetX = if (textView.x > 10) textView.x - 100 else frameLayout.width - 100f
            animateTextView(textView.x, targetX, textView.y, textView.y)
        }

        buttonUp.setOnClickListener {
            // Move the text up with animation
            val targetY = if (textView.y > 10) textView.y - 100 else frameLayout.height - 100f
            animateTextView(textView.x, textView.x, textView.y, targetY)
        }

        buttonRight.setOnClickListener {
            // Move the text right with animation
            val targetX = if (textView.x + textView.width < frameLayout.width - 10) textView.x + 100 else 0f
            animateTextView(textView.x, targetX, textView.y, textView.y)
        }

        buttonDown.setOnClickListener {
            // Move the text down with animation
            val targetY = if (textView.y + textView.height < frameLayout.height - 10) textView.y + 100 else 0f
            animateTextView(textView.x, textView.x, textView.y, targetY)
        }
    }

    // Function to animate the TextView movement
    private fun animateTextView(startX: Float, endX: Float, startY: Float, endY: Float) {
        val animatorX = ObjectAnimator.ofFloat(textView, "x", startX, endX)
        val animatorY = ObjectAnimator.ofFloat(textView, "y", startY, endY)
        animatorX.duration = 300
        animatorY.duration = 300
        animatorX.start()
        animatorY.start()
    }
}