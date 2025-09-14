package com.example.socially

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var bottomNav: BottomNavigationView
    private var currentMenuId: Int = R.id.nav_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottomNav = findViewById(R.id.bottom_nav)
        bottomNav.itemIconTintList = null

        // restore selected tab after rotation
        currentMenuId = savedInstanceState?.getInt("selected_tab") ?: R.id.nav_home

        // first tab
        switchTo(currentMenuId, addIfMissing = true)

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_add -> {
                    val intent = Intent(this, PostImageActivity::class.java)
                    startActivity(intent)
                    bottomNav.selectedItemId = currentMenuId
                    false
                }
                else -> {
                    if (item.itemId == currentMenuId) return@setOnItemSelectedListener true
                    switchTo(item.itemId, addIfMissing = true)
                    true
                }
            }
        }

    }

    private fun switchTo(menuId: Int, addIfMissing: Boolean) {
        val fm = supportFragmentManager
        val tx = fm.beginTransaction()

        // hide current
        fm.findFragmentByTag(tagFor(currentMenuId))?.let { tx.hide(it) }

        // show or add target
        var target = fm.findFragmentByTag(tagFor(menuId))
        if (target == null && addIfMissing) {
            target = createFragment(menuId)
            tx.add(R.id.fragment_container, target, tagFor(menuId))
        } else if (target != null) {
            tx.show(target)
        }

        tx.commit()
        currentMenuId = menuId
        bottomNav.selectedItemId = menuId
    }

    private fun createFragment(menuId: Int): Fragment = when (menuId) {
        R.id.nav_home     -> HomeFragment()
        R.id.nav_search   -> SearchFragment()
        //R.id.nav_add      -> AddFragment()
        R.id.nav_likes    -> LikesFragment()
        R.id.nav_profile  -> ProfileManagement()
        else              -> HomeFragment()
    }

    private fun tagFor(menuId: Int) = "TAB_$menuId"

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("selected_tab", currentMenuId)
        super.onSaveInstanceState(outState)
    }
}
