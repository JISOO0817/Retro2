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



      /*  String name = movie.getName();
        String img = movie.getImg();
        String description = movie.getDescription();
        float booking = movie.getBooking();
        int rating = movie.getRating();
        String categorie = movie.getCategorie();
        String release = movie.getRelease();

        holder.nameTv.setText(name);
        holder.categorieTv.setText(categorie);
        holder.relaseTv.setText(release);
        holder.bookingTv.setText((int) booking);
        holder.ratingTv.setText(rating);
        holder.descriptionTv.setText(description);


*/
        holder.idTv.setText(movieList.get(position).getId());
        holder.nameTv.setText(movieList.get(position).getName());

        try{

      //      Picasso.get().load(img).into(holder.movieIv);
            Picasso.get().load(movieList.get(position).getImage()).placeholder(R.drawable.ic_launcher_background).into(holder.imageIv);
        }catch (Exception e){}






    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

     /*   private TextView nameTv,descriptionTv,ratingTv,bookingTv,relaseTv,categorieTv;
        private ImageView movieIv;*/

        TextView idTv,nameTv;
        ImageView imageIv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            idTv = itemView.findViewById(R.id.idTv);
            nameTv = itemView.findViewById(R.id.idTv);
            imageIv = itemView.findViewById(R.id.imageIv);
      /*      nameTv = itemView.findViewById(R.id.nameTv);
            movieIv = itemView.findViewById(R.id.movieIv);
            descriptionTv = itemView.findViewById(R.id.descriptionTv);
            ratingTv = itemView.findViewById(R.id.ratingTv);
            bookingTv = itemView.findViewById(R.id.bookingTv);
            relaseTv = itemView.findViewById(R.id.releaseTv);
            categorieTv = itemView.findViewById(R.id.categorieTv);*/





        }
    }
}
