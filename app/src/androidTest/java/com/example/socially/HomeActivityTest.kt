package com.example.socially

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(HomeActivity::class.java)

    // Test 1: Bottom nav is visible
    @Test
    fun testBottomNavIsDisplayed() {
        onView(withId(R.id.bottom_nav))
            .check(matches(isDisplayed()))
    }

    // Test 2: Navigates to Search fragment
    @Test
    fun testNavigateToSearch() {
        onView(withId(R.id.nav_search)).perform(click())

        onView(withId(R.id.search_root))
            .check(matches(isDisplayed()))
    }
}
