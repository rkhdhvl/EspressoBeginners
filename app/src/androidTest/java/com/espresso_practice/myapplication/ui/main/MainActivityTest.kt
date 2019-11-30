package com.espresso_practice.myapplication.ui.main

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.espresso_practice.myapplication.R
import kotlinx.android.synthetic.main.activity_main.view.*
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{

    // initial basic test
    // test to check if the activity launches and if the main container is in view
    @Test
    fun test_isActivityInView(){
      // this launches a fake simulated activity with Espresso
      val activityScenario = ActivityScenario.launch(MainActivity::class.java)
      onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    // Testing if the title and button are displayed
    @Test
    fun test_visibility_title_and_nextButton(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.activity_main_title)).check(matches(isDisplayed()))
        // There ar 2 ways to test the visibility
        // method no 1
        onView(withId(R.id.button_next_activity)).check(matches(isDisplayed()))
        // mrthod no 2
        onView(withId(R.id.button_next_activity)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    // Test for checking if the title text is displayed
    @Test
    fun test_checkTitleTextDisplayed()
    {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.activity_main_title)).check(matches(withText(R.string.text_mainactivity)))
    }

    // navigate and test if the secondary activity is visible
    @Test
    fun test_navSecondaryActivity()
    {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.button_next_activity)).perform(click())
        onView(withId(R.id.secondary)).check(matches(isDisplayed()))
    }

    @Test
    fun test_goToMainActivity_onBackButton_click()
    {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.button_next_activity)).perform(click())
        onView(withId(R.id.secondary)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

}