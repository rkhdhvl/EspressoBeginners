package com.espresso_practice.myapplication.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.espresso_practice.myapplication.R
import com.espresso_practice.myapplication.ui.main.fragments.MovieDetailFragment
import com.espresso_practice.myapplication.ui.main.fragments.MovieFragmentFactory

class MovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        supportFragmentManager.fragmentFactory = MovieFragmentFactory()
        init()
    }

    fun init()
    {
        if(supportFragmentManager.fragments.size == 0){
            val movieId = 1
            val bundle = Bundle()
            bundle.putInt("movie_id", movieId)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MovieDetailFragment::class.java, bundle)
                .commit()
        }
    }
}
