package com.example.baker.sqlitedatabaseexample;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MovieDetailsActivity extends AppCompatActivity {

    private  String movieName,movieYear;
    private int rowId;
    private TextView nameTV,yearTV;
    private MovieDatabaseSource movieDatabaseSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        
        movieDatabaseSource=new MovieDatabaseSource(this);
        nameTV= (TextView) findViewById(R.id.details_movieName);
        yearTV= (TextView) findViewById(R.id.details_movieYear);

        movieName=getIntent().getStringExtra("name");
        movieYear=getIntent().getStringExtra("year");
        rowId=getIntent().getIntExtra("id",0);//0 ,dia initallly kono kiso na pele 0 bosabe
//        Toast.makeText(this, movieName, Toast.LENGTH_SHORT).show();
        nameTV.setText(movieName);
        yearTV.setText(movieYear);
    }

    public void updateMovie(View view) {
        startActivity(new Intent(MovieDetailsActivity.this,MainActivity.class)
                .putExtra("id",rowId)
                .putExtra("name",movieName)
                .putExtra("year",movieYear));
    }

    public void deleteMovie(View view) {
        AlertDialog.Builder alert=new AlertDialog.Builder(this);
        alert.setTitle("Delete Item");
        alert.setMessage("Are you sure to delete this item");
        alert.setPositiveButton("sure", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                boolean status=movieDatabaseSource.deleteMovie(rowId);
                if (status){
                    Toast.makeText(MovieDetailsActivity.this, "Item Deleted", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MovieDetailsActivity.this,MovieListActivity.class));
                }else{
                    Toast.makeText(MovieDetailsActivity.this, "Coudn't Delete", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alert.setNegativeButton("Cancel",null);
        alert.show();


    }
}
