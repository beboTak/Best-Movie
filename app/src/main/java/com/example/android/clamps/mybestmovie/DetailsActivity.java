package com.example.android.clamps.mybestmovie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import utils.JsonDownloader;

public class DetailsActivity extends AppCompatActivity {

    TextView rate,date,overView;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        rate=(TextView)findViewById(R.id.rate_mov);
        date=(TextView)findViewById(R.id.date_mov);
        overView=(TextView)findViewById(R.id.overview_mov);
        img=(ImageView)findViewById(R.id.im_mov);


        Intent intent=this.getIntent();


        String title=intent.getExtras().getString("title");
        String poster_path=intent.getExtras().getString("poster_path");
        String   overview=intent.getExtras().getString("overview");
        String rate_movie= intent.getExtras().getString("rate_movie");
        String release_date=intent.getExtras().getString("release_date");

        rate.setText(rate_movie);
        overView.setText(overview);
        date.setText(release_date);
        setTitle(title);

        Picasso.get().load(poster_path).resize(400,300).into(img);

    }
}
