package com.carllewis14.moviegallery.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.carllewis14.moviegallery.DataModel.Movie;
import com.carllewis14.moviegallery.R;
import com.squareup.picasso.Picasso;

/**
 * Data Adapter Class
 */

public class DataAdapter extends BaseAdapter {

    private Context mContext;
    private Movie[] movies;

    public DataAdapter(Context mContext, Movie[] movies) {
        this.mContext = mContext;
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Movie movie = movies[position];

        if (convertView == null){
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.movie_layout, null);
        }

        final ImageView imageView = (ImageView)convertView.findViewById(R.id.imageviewCover);
        final TextView nameTextView = (TextView)convertView.findViewById(R.id.tvMovieName);
        final ImageView imageViewFavourite = (ImageView)convertView.findViewById(R.id.favourite);

        Picasso.with(mContext)
                .load(movie.getImageUrl())
                .placeholder(R.mipmap.ic_launcher)
                .resize(300, 500)
                .into(imageView);

        nameTextView.setText(movie.getName());
        imageViewFavourite.setImageResource(
                movie.getIsFavourite() ? R.drawable.ic_favourite : R.drawable.ic_not_favourite);

        return convertView;
    }
}
