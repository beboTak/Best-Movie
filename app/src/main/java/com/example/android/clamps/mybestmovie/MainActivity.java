package com.example.android.clamps.mybestmovie;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;

import utils.JsonDownloader;
import utils.JsonUtils;

public class MainActivity extends AppCompatActivity {

    String jsonPopulated="https://api.themoviedb.org/3/movie/popular?page=1&language=en-US&api_key=";
    String jsonTopRared="https://api.themoviedb.org/3/movie/top_rated?page=1&language=en-US&api_key=";
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView=(GridView)findViewById(R.id.movie_grideview);
       // if  want to open app on result
       // new JsonDownloader(MainActivity.this,  jsonPopulated,gridView).execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.mainmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        if (id==R.id.most_popular)
          {
            new JsonDownloader(MainActivity.this,  jsonPopulated,gridView).execute();
            return true;
          }
        if (id==R.id.highest_rated)
          {
                new JsonDownloader(MainActivity.this,jsonTopRared,gridView).execute();
                return true;
          }
        return super.onOptionsItemSelected(item);
    }
}
