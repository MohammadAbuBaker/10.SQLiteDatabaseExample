package com.example.baker.sqlitedatabaseexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nameET;
    private EditText yearET;
    private Movie movie;
    private MovieDatabaseSource movieDatabaseSource;
    private Button addBtn;

    private String movieName,moviYear;
    private int rowId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        nameET= (EditText) findViewById(R.id.movieNameET);
        yearET= (EditText) findViewById(R.id.movieYearET);
        addBtn= (Button) findViewById(R.id.addBtn);
        movieDatabaseSource=new MovieDatabaseSource(this);

        //for update
        rowId=getIntent().getIntExtra("id",0);
        movieName=getIntent().getStringExtra("name");
        moviYear=getIntent().getStringExtra("year");

        nameET.setText(movieName);
        yearET.setText(moviYear);
        if(rowId>0){
            addBtn.setText("Update");
        }



        
    }

    public void addMovie(View view) {
        
        String name=nameET.getText().toString();
        String year=yearET.getText().toString();
        if(name.isEmpty()){
            nameET.setError("This field must not be empty!");
        }else if(year.isEmpty()){
            yearET.setError("This field must not be empty!");
        }else{
            if (rowId>0){
                movie=new Movie(name,year,rowId);
                boolean status=movieDatabaseSource.updateMovie(movie,rowId);
                if(status){
                    Toast.makeText(this, "Update", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,MovieListActivity.class));
                }else{
                    Toast.makeText(this, "Faild to Update", Toast.LENGTH_SHORT).show();
                }
                
                
            }else{
                nameET.setText("");
                yearET.setText("");
                movie=new Movie(name,year);
                boolean status=movieDatabaseSource.addMovie(movie);
                if (status){
                    Toast.makeText(this, "Successfull", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,MovieListActivity.class));
                }else{
                    Toast.makeText(this, "Could not Save", Toast.LENGTH_SHORT).show();
                }
            }
           
        }
    }

    public void viewMovie(View view) {
        startActivity(new Intent(MainActivity.this,MovieListActivity.class));
    }
}
