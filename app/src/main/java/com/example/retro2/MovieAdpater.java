package com.example.retro2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

        String id = movie.getId();
        String name = movie.getName();
        String image = movie.getImage();

        holder.idTv.setText(id);
        holder.nameTv.setText(name);

        try{
            Picasso.get().load(image).placeholder(R.drawable.ic_launcher_background).into(holder.imageIv);
        }catch (Exception e){}








    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{


        TextView idTv,nameTv;
        ImageView imageIv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            idTv = itemView.findViewById(R.id.idTv);
            nameTv = itemView.findViewById(R.id.nameTv);
            imageIv = itemView.findViewById(R.id.imageIv);


        }
    }
}
