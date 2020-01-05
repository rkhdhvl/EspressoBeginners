package com.espresso_practice.myapplication.ui.main.fragments

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.espresso_practice.myapplication.R
import kotlinx.android.synthetic.main.fragment_directors.view.*
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DirectorsFragmentTest
{
    @Test
   fun test_isDirectorsListVisible()
   {
    val directors = arrayListOf<String>("R.J. Stewart", "James Vanderbilt")
    val fragmentFactory = MovieFragmentFactory()
    val bundle = Bundle()
    bundle.putStringArrayList("args_directors",directors)
    val scenario = launchFragmentInContainer<DirectorsFragment> (
        fragmentArgs = bundle,
        factory= fragmentFactory
    )
       // verify with the view
       onView(withId(R.id.directors_text)).check(matches(withText(DirectorsFragment.stringBuilderForDirectors(directors))))
   }
}