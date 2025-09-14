package com.example.socially

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class LikesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_likes, container, false)

        val tabFollowing: TextView = view.findViewById(R.id.tab_following)
        val tabYou: TextView = view.findViewById(R.id.tab_you)

        // Switch to You tab
        tabYou.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LikesYouFragment())
                .commit() // no addToBackStack, prevents stack overflow
        }

        return view
    }
}
