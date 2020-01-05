package com.espresso_practice.myapplication.ui.main.fragments

import org.junit.runner.RunWith
import org.junit.runners.Suite


@RunWith(Suite::class)
@Suite.SuiteClasses(
    MovieDetailFragmentTest::class,
    DirectorsFragmentTest::class,
    StarActorsFragmentTest::class,
    MovieNavigationTest::class
)
class MovieFragmentsTestSuite {
}