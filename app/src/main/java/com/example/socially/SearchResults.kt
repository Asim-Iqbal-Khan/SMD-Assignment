package com.example.socially

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

class SearchResultsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_results, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userLayout = view.findViewById<LinearLayout>(R.id.user)

        userLayout.setOnClickListener {
            // Open ProfileViewFragment
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ProfileViewFragment()) // container from HomeActivity
                .addToBackStack(null) // allows going back
                .commit()
        }
    }
}
