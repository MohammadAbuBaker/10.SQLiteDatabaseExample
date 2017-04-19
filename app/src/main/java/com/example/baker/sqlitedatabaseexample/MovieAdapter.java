package com.example.baker.sqlitedatabaseexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by baker on 4/19/2017.
 */

public class MovieAdapter extends ArrayAdapter<Movie>{

    private Context context;
    private ArrayList<Movie> movies;
    public MovieAdapter(@NonNull Context context, ArrayList<Movie> movies) {
        super(context, R.layout.row_layout, movies);
        this.context=context;
        this.movies = movies;
    }

    class ViewHolder{
        TextView nameTV;
        TextView phoneTV;
        ImageView myImage;
    }

    //Ctrl+o dile ,getView likle pawa jabe
    //scren e joto ta row dakano jabe ,os toto bar aita cal korbe
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);//aita custom layout nia asbe

        ViewHolder holder;
        if (convertView==null){
            holder=new ViewHolder();

            convertView=inflater.inflate(R.layout.row_layout,parent,false);
            holder.nameTV= (TextView) convertView.findViewById(R.id.movieName);
            holder.phoneTV= (TextView) convertView.findViewById(R.id.movieYear);
            holder.myImage= (ImageView) convertView.findViewById(R.id.myImage);

            convertView.setTag(holder);//View somporke extra info
        }else{
            holder= (ViewHolder) convertView.getTag();
        }



        holder.nameTV.setText(movies.get(position).getMoviName());
        holder.phoneTV.setText(movies.get(position).getMovieYear());

        return convertView;




    }
}
