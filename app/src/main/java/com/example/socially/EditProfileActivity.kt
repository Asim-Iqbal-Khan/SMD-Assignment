package com.example.socially

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class EditProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_profile)

        val btnDone: TextView = findViewById(R.id.done_button)
        val btnCancel: TextView = findViewById(R.id.cancel_button)

        btnDone.setOnClickListener {
            finish()
        }

        btnCancel.setOnClickListener {
            finish()
        }
    }
}
