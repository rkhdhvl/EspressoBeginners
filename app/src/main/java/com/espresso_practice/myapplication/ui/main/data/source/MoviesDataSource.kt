package com.espresso_practice.myapplication.ui.main.data.source

import com.espresso_practice.myapplication.ui.main.data.Movie


interface MoviesDataSource {

    fun getMovie(movieId: Int): Movie?
}