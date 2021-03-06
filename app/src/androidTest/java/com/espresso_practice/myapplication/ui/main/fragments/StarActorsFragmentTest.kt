package com.espresso_practice.myapplication.ui.main.fragments

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.espresso_practice.myapplication.R
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class StarActorsFragmentTest{

    @Test
    fun test_if_starListIsVisible()
    {
        // setup
      val stars = arrayListOf("Dwayne Johnson", "Seann William Scott", "Rosario Dawson", "Christopher Walken")
        val factory = MovieFragmentFactory()
        val bundle = Bundle()
        bundle.putStringArrayList("args_actors",stars)

        // act
        val fragmentScenario = launchFragmentInContainer<StarActorsFragment>(
            fragmentArgs = bundle,
            factory= factory
        )

        // assert or verify
       onView(withId(R.id.star_actors_text)).check(matches(withText(StarActorsFragment.stringBuilderForStarActors(stars))))
    }

}