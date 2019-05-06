package utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.GridView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import adapter.MovieAdapter;
import model.Movie;

public class JsonUtils extends AsyncTask<Void,Void,Boolean> {

    Context c;
    String jsonData;
    GridView gv;

    ProgressDialog pd;
    List<Movie>movies=new ArrayList<>();

    public JsonUtils(Context c, String jsonData, GridView gv) {
        this.c = c;
        this.jsonData = jsonData;
        this.gv = gv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd=new ProgressDialog(c);
        pd.setTitle("arse...JSON");
        pd.setMessage("Parsing...Please Wait");
        pd.show();

    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        return this.parse();
    }

    @Override
    protected void onPostExecute(Boolean isPassed) {
        super.onPostExecute(isPassed);

        pd.dismiss();
        if (isPassed)
        {
            MovieAdapter adapter=new MovieAdapter(c,movies);
            gv.setAdapter(adapter);
        }
        else
            {
                Toast.makeText(c,"Unable To Parse Check Log Output",Toast.LENGTH_SHORT).show();
            }
    }

    private Boolean parse()
    {
        try
        {
            JSONObject jsonObject=new JSONObject(jsonData);
            JSONArray ja=jsonObject.getJSONArray("results");

            JSONObject jo=null;
            Movie movie = null;
            movies.clear();

            for (int i=0;i<ja.length();i++)
            {
              jo=ja.optJSONObject(i);
              String title=jo.optString("original_title");
              String poster_path="http://image.tmdb.org/t/p/w185"+jo.optString("poster_path");
              String overview=jo.optString("overview");
              Double vore_average=  jo.optDouble("vote_average");
              String release_date=jo.optString("release_date");
              movie=new Movie();

              movie.setTitle(title);
              movie.setPoster_path(poster_path);
              movie.setOverview(overview);
              movie.setVote_average(vore_average);
              movie.setRelease_date(release_date);
              movies.add(movie);


            }
            return true;



        }catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }























}
