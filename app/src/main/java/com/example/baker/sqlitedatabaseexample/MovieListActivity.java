package com.example.baker.sqlitedatabaseexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MovieListActivity extends AppCompatActivity {
    private ListView mListView;
    private MovieAdapter movieAdapter;
    private ArrayList<Movie>movies;
    private MovieDatabaseSource movieDatabaseSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        mListView= (ListView) findViewById(R.id.movieList);
        movieDatabaseSource=new MovieDatabaseSource(this);
        movies=movieDatabaseSource.getAllMovie();
        movieAdapter=new MovieAdapter(this,movies);
        mListView.setAdapter(movieAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name=movies.get(position).getMoviName();
                String year=movies.get(position).getMovieYear();
                int rowId=movies.get(position).getMovieId();
                startActivity(new Intent(MovieListActivity.this,MovieDetailsActivity.class)
                .putExtra("id",rowId)
                .putExtra("name",name)
                .putExtra("year",year));
            }
        });

    }
}
