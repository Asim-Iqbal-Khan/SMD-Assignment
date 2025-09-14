package com.example.socially

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class StoryEditOwnActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_story_edit_own)

        // Close button → finish activity
        val closeIcon = findViewById<ImageView>(R.id.close_icon)
        closeIcon.setOnClickListener {
            finish()
        }

        val postButton = findViewById<ImageView>(R.id.post)
        postButton.setOnClickListener {
            val intent = Intent(this, StoryViewOwnActivity::class.java)
            startActivity(intent)
        }
    }
}
