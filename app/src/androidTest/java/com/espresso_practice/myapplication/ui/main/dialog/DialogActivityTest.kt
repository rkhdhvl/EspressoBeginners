package com.espresso_practice.myapplication.ui.main.dialog

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.espresso_practice.myapplication.R
import com.espresso_practice.myapplication.ui.main.dialog.DialogActivity.Companion.buildToast
import kotlinx.android.synthetic.main.activity_dialog.view.*
import org.hamcrest.CoreMatchers.not
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DialogActivityTest {

    @Test
    fun test_showDialog_captureNameInput() {
        // Given
        val activityAction = ActivityScenario.launch(DialogActivity::class.java)
        val expectedName = "Rakhi"
        // Execute
        onView(withId(R.id.button_launch_dialog)).perform(click())
        onView(withText(R.string.text_enter_name)).check(matches(isDisplayed()))
        //clicking on the dialog ok button
        onView(withText(R.string.ok_)).perform(click())
        // Without the user entering anything the dialog should be displayed, so checking that
        onView(withText(R.string.text_enter_name)).check(matches(isDisplayed()))
        onView(withId(R.id.md_input_message)).perform(typeText(expectedName))
        // after entering the name click on Ok
        onView(withText(R.string.ok_)).perform(click())
        // making sure that the dialog is gone after entering name and clicking ok
        onView(withText(R.string.text_enter_name)).check(doesNotExist())
        // confirming that the name is set to the textView
        onView(withId(R.id.text_name)).check(matches(withText(expectedName)))
        // checking if the toast is getting displayed
        onView(withText(buildToast(expectedName)))
    }

}