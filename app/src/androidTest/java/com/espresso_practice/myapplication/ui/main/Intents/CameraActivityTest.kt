package com.espresso_practice.myapplication.ui.main.Intents

import android.app.Activity
import android.app.Instrumentation
import android.content.ContentResolver
import android.content.Intent
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.isClickable
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import com.espresso_practice.myapplication.R
import com.espresso_practice.myapplication.ui.main.Intents.ImageViewHasDrawableMatcher.hasDrawable
import org.hamcrest.Matcher
import org.hamcrest.Matchers.not
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class CameraActivityTest{

    @get:Rule
    val intentsTestRule = IntentsTestRule(CameraActivity::class.java)

    @Test
    fun test_camera_intent_isBitmapSetToImageView()
    {
        val activityResult = createImageCaptureActivityResultStub()
        val expectedIntent : Matcher<Intent> = hasAction(MediaStore.ACTION_IMAGE_CAPTURE)
        intending(expectedIntent).respondWith(activityResult)
        // Execute and verify
        // before launching camera intent the image should not have any drawable set to it
        onView(withId(R.id.image)).check(matches(not(hasDrawable())))
        onView(withId(R.id.button_launch_camera)).perform(click())
        intending(expectedIntent)
        onView(withId(R.id.image)).check(matches(hasDrawable()))
    }

    private fun createImageCaptureActivityResultStub(): Instrumentation.ActivityResult {
        val bundle = Bundle()
        bundle.putParcelable(KEY_IMAGE_DATA,
            BitmapFactory.decodeResource(
                intentsTestRule.activity.resources,
                R.drawable.ic_launcher_background
            ))
        val resultData = Intent()
        resultData.putExtras(bundle)
        return Instrumentation.ActivityResult(Activity.RESULT_OK,resultData)
    }

}