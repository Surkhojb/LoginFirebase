package juanjo.example.loginfirebase.ui.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import juanjo.example.loginfirebase.R;
import juanjo.example.loginfirebase.data.model.Image;
import juanjo.example.loginfirebase.data.model.Serie;
import juanjo.example.loginfirebase.data.model.SingleSerie;

/**
 * Created by juanjoberenguer on 22/6/17.
 */

public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.ViewHolder> {

    List<Serie> serieList;

    public SeriesAdapter(List<Serie> s){
        serieList = s;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_serie_recycler,null);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(serieList.get(position).getShow().getImage() != null){
            Glide.with(holder.imageSerie.getContext()).
                    load(serieList.get(position).getShow().getImage().getOriginal())
                    .into(holder.imageSerie);
        }
        else{
            Glide.with(holder.imageSerie.getContext()).
                    load("http://aggv.ca/sites/default/files/image-not-available.png")
                    .into(holder.imageSerie);
        }
        holder.textTilte.setText(serieList.get(position).getShow().getName());
        holder.textSeason.setText(serieList.get(position).getShow().getPremiered());
        holder.textGenre.setText(Arrays.toString(serieList.get(position)
                .getShow().getGenres().toArray())
                .replace("[","").replace("]",""));
        if(serieList.get(position).getShow().getRating().getAverage() == null){
            holder.textRating.setText("-");
        }else{
            holder.textRating.setText(String.valueOf(serieList.get(position).getShow()
                .getRating().getAverage()));
        }
    }

    @Override
    public int getItemCount() {
        return serieList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageSerie;
        TextView textTilte;
        TextView textSeason;
        TextView textGenre;
        TextView textRating;

        public ViewHolder(View itemView) {
            super(itemView);

            imageSerie = (ImageView) itemView.findViewById(R.id.item_image);
            textTilte = (TextView) itemView.findViewById(R.id.item_title);
            textSeason = (TextView) itemView.findViewById(R.id.item_year_season);
            textGenre = (TextView) itemView.findViewById(R.id.item_genre);
            textRating = (TextView) itemView.findViewById(R.id.item_rating);

        }
    }
}
