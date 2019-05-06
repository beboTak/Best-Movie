package adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.clamps.mybestmovie.DetailsActivity;
import com.example.android.clamps.mybestmovie.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import model.Movie;

public class MovieAdapter  extends BaseAdapter {
    Context context;
    List<Movie> movies;

    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
       if (view==null)
       {

           view=LayoutInflater.from(context).inflate(R.layout.movie_item,parent,false);
       }

       // TextView rate=(TextView)view.findViewById(R.id.movie_vote);
        ImageView im=(ImageView)view.findViewById(R.id.movie_img);


        Movie movie=(Movie) this.getItem(position);
        final String title=movie.getTitle();
        final String poster_path=movie.getPoster_path();
        final String overview=movie.getOverview();
        final String rate_movie=String.valueOf(movie.getVote_average());
        final String release_date=movie.getRelease_date();

        //rate.setText(rate_movie);
        Picasso.get().load(poster_path).resize(200,180).into(im);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailsActivity(title,poster_path,overview,rate_movie,release_date);

            }
        });
        return view;


    }




    public void openDetailsActivity(String...details)
    {
        Intent intent=new Intent(context, DetailsActivity.class);
        intent.putExtra("title",details[0]);
        intent.putExtra("poster_path",details[1]);
        intent.putExtra("overview",details[2]);
        intent.putExtra("rate_movie",details[3]);
        intent.putExtra("release_date",details[4]);

        context.startActivity(intent);


    }


}
