package com.example.retro2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdpater extends RecyclerView.Adapter<MovieAdpater.ViewHolder>{

    private Context context;
    private List<Movie> movieList;


    public MovieAdpater(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.movie_item,parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Movie movie = movieList.get(position);

        int id = movie.getId();
        String title = movie.getTitle();
        float rating = movie.getRating();
        String poster = movie.getPoster();



        holder.idTv.setText(String.valueOf(id));
        holder.titleTv.setText(title);
        holder.durationTv.setText(movieList.get(position).getMoreDetails().getDuration());
        holder.categoryTv.setText(movieList.get(position).getMoreDetails().getCategory());
        holder.releaseTv.setText(movieList.get(position).getMoreDetails().getRelease());
        holder.ratingBar.setRating(rating/2);

        try{
            Picasso.get().load(poster).placeholder(R.drawable.ic_launcher_background).into(holder.imageIv);
        }catch (Exception e){}








    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{


        TextView idTv,titleTv,releaseTv,categoryTv,durationTv;
        ImageView imageIv;
        RatingBar ratingBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            idTv = itemView.findViewById(R.id.idTv);
            titleTv = itemView.findViewById(R.id.titleTv);
            imageIv = itemView.findViewById(R.id.imageIv);
            releaseTv = itemView.findViewById(R.id.releaseTv);
            categoryTv = itemView.findViewById(R.id.categoryTv);
            durationTv = itemView.findViewById(R.id.durationTv);
            ratingBar = itemView.findViewById(R.id.ratingBar);

        }
    }
}
