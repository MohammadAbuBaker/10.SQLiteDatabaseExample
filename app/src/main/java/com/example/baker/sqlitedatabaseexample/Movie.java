package com.example.baker.sqlitedatabaseexample;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by baker on 4/19/2017.
 */

public class Movie implements Serializable{
    private String moviName;
    private String movieYear;
    private int movieId;

    public Movie() {
    }

    public Movie(String moviName, String movieYear) {
        this.moviName = moviName;
        this.movieYear = movieYear;
    }

    public Movie(String moviName, String movieYear, int movieId) {
        this.moviName = moviName;
        this.movieYear = movieYear;
        this.movieId = movieId;
    }

    public String getMoviName() {
        return moviName;
    }

    public void setMoviName(String moviName) {
        this.moviName = moviName;
    }

    public String getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(String movieYear) {
        this.movieYear = movieYear;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }


}
