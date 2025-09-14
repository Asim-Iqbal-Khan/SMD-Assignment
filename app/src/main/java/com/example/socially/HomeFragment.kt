package com.example.socially

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment

class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Messages icon
        val messagesIcon: View? = view.findViewById(R.id.ic_dm)
        messagesIcon?.setOnClickListener {
            val intent = Intent(requireContext(), MessageActivity::class.java)
            startActivity(intent)
        }

        // Story icon
        val story: ImageView? = view.findViewById(R.id.otherstory)
        story?.setOnClickListener {
            val intent = Intent(requireContext(), StoryViewOthersActivity::class.java)
            startActivity(intent)
        }
    }
}
