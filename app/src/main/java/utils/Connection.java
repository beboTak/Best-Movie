package utils;



import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Connection {
    public static Object connection(String jsonUrl)
    {

        try
        {

            URL url=new URL(jsonUrl);
            HttpURLConnection con= (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.setConnectTimeout(15000);
            con.setReadTimeout(15000);
            con.setDoInput(true);

            return con;
        }catch (MalformedURLException e)
        {
            e.printStackTrace();
            return "Error "+e.getMessage();
        }

        catch (IOException e)
        {
            e.printStackTrace();
            return "Error "+e.getMessage();
        }
    }

}
