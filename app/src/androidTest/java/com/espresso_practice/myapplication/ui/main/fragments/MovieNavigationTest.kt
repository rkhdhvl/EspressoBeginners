package com.espresso_practice.myapplication.ui.main.fragments

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.espresso_practice.myapplication.R
import com.espresso_practice.myapplication.ui.main.MovieActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MovieNavigationTest {

    @Test
    fun testMovieFragmentNavigation()
    {
        //setup
        val activityScenario = ActivityScenario.launch(MovieActivity::class.java)
        // perform click to view the directors fragment
        onView(withId(R.id.movie_directiors)).perform(click())
        // verify that the director's fragment is visible
        onView(withId(R.id.fragment_movie_directors_parent)).check(matches(isDisplayed()))
        // on back press should go back to the movie details screen
        pressBack()
        // detail fragment should be visible
        onView(withId(R.id.fragment_movie_detail_parent)).check(matches(isDisplayed()))
        // now navigate to actors fragment
        onView(withId(R.id.movie_star_actors)).perform(click())
        // Verify that the actors fragment is visible
        onView(withId(R.id.fragment_movie_stars_actors_parent)).check(matches(isDisplayed()))
    }

}