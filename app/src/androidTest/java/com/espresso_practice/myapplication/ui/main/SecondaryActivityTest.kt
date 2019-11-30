package com.espresso_practice.myapplication.ui.main

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.espresso_practice.myapplication.R
import kotlinx.android.synthetic.main.activity_secondary.view.*
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SecondaryActivityTest{

    // Writing a rule for all test methods
    @get: Rule
    val  activityRule = ActivityScenarioRule(SecondaryActivity::class.java)

    // testing if the actvity conatiner is displayed with help of the id
    @Test
    fun test_isActivityInView(){
        onView(withId(R.id.secondary))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_visibility_title_and_backButton()
    {
        onView(withId(R.id.activity_secondary_title)).check(matches(isDisplayed()))
        onView(withId(R.id.button_back)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isTitleTextDisplayed()
    {
        onView(withId(R.id.activity_secondary_title)).check(matches(isDisplayed()))
    }

}