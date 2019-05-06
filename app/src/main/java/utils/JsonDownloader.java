
package utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.GridView;
import android.widget.Toast;

import com.example.android.clamps.mybestmovie.DetailsActivity;
import com.example.android.clamps.mybestmovie.R;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class JsonDownloader extends AsyncTask<Void,Void,String> {

    Context c;
    String jsonURL;
    GridView gv;

    ProgressDialog pd;

    public JsonDownloader() {
    }

    public JsonDownloader(Context c, String jsonURL, GridView gv) {
        this.c = c;
        this.jsonURL = jsonURL;
        this.gv = gv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        int downloading=R.string.jsonDownlodaing;

        pd=new ProgressDialog(c);
        pd.setTitle(R.string.jsonDonload);
        pd.setMessage("Parsing...Please Wait ");
        pd.show();
    }

    @Override
    protected String doInBackground(Void... voids) {
        return download();
    }

    @Override
    protected void onPostExecute(String jsonData) {
        super.onPostExecute(jsonData);

        pd.dismiss();

        if (jsonData.startsWith("Error"))
        {
            String error=jsonData;
            Toast.makeText(c,error,Toast.LENGTH_SHORT).show();
        }
        else
        {
            new JsonUtils(c,jsonData,gv).execute();
        }
    }

    public String download()
    {

      Object connection=Connection.connection(jsonURL);

      if (connection.toString().startsWith("Error"))
      {
          return connection.toString();
      }

      try
      {
          HttpURLConnection con=(HttpURLConnection) connection;
          if (con.getResponseCode()==con.HTTP_OK)
          {
              InputStream is=new BufferedInputStream(con.getInputStream());
              BufferedReader br=new BufferedReader(new InputStreamReader(is));

              String line="";

              StringBuffer jsonData=new StringBuffer();

              while ((line=br.readLine())!=null)
              {
                  jsonData.append(line+"\n");

              }

              br.close();
              is.close();

              return jsonData.toString();



          }
          else {
              return "Error "+con.getResponseMessage();
          }



      } catch (IOException e) {
          e.printStackTrace();
          return "Error "+e.getMessage();
      }

    }
}
