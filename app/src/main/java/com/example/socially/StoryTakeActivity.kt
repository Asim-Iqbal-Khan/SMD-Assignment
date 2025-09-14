package com.example.socially

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class StoryTakeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_story_take)

        // Close button → go back
        val closeIcon = findViewById<ImageView>(R.id.close_icon)
        closeIcon.setOnClickListener {
            finish()
        }

        // Capture button → open StoryEditOwnActivity
        val captureButton = findViewById<ImageView>(R.id.capture_button)
        captureButton.setOnClickListener {
            val intent = Intent(this, StoryEditOwnActivity::class.java)
            startActivity(intent)
        }
    }
}
