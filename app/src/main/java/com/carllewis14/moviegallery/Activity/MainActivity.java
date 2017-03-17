package com.carllewis14.moviegallery.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.GridView;

import com.carllewis14.moviegallery.Adapter.DataAdapter;
import com.carllewis14.moviegallery.DataModel.Movie;
import com.carllewis14.moviegallery.R;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private Movie[] movies = {
            new Movie("Pulp Fiction","https://www.androidtutorialpoint.com/wp-content/uploads/2016/10/pulpfiction.jpg"),
            new Movie("Interstellar","https://www.androidtutorialpoint.com/wp-content/uploads/2016/10/interstellar.jpg"),
            new Movie("Batman v/s Superman","https://www.androidtutorialpoint.com/wp-content/uploads/2016/10/batmanvssuperman.jpg"),
            new Movie("Iron Man","https://www.androidtutorialpoint.com/wp-content/uploads/2016/10/ironman.jpg"),
            new Movie("Inception","https://www.androidtutorialpoint.com/wp-content/uploads/2016/10/inception.jpg"),
            new Movie("Avengers","https://www.androidtutorialpoint.com/wp-content/uploads/2016/10/avengers.jpg"),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView)findViewById(R.id.gridView);
        final DataAdapter movieAdapter = new DataAdapter(this, movies);
        gridView.setAdapter(movieAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, android.view.View view, int position, long id) {
                Movie movie = movies[position];
                movie.toggleFavourite();

                // This tells the GridView to redraw itself
                // in turn calling your MovieAdapter's getView method again for each cell
                movieAdapter.notifyDataSetChanged();
            }
        });
    }
}
