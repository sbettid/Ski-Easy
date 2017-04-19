package skieasy.decy.it.ski_easy;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Davide on 19/04/2017.
 */

class WeatherForecasts extends AsyncTask<String,String,String>{


    public AsyncResponse delegate = null;

    public WeatherForecasts(AsyncResponse s){
        delegate = s;
    }



    @Override
    protected String doInBackground(String... params) {
        //Load weather forecasts from openwather.com using their API
        String apikey = "80634df8f9b5e5e561d6ac78eadba130";
        String urlAddress = "http://api.openweathermap.org/data/2.5/forecast/daily";
        String response = "";
        String fullURL = urlAddress + "?APPID=" + apikey + "&q=bolzano";

        String json = "";

        try {
            URL myUrl = new URL(fullURL);

            URLConnection myConn = myUrl.openConnection();

            //Log.d("WEATHER", "" + myConn.getURL());
            HttpURLConnection myHttp = null;

            if(myConn instanceof HttpURLConnection){
                myHttp = (HttpURLConnection) myConn;
            }else{
                Log.d("WEATHER", "Problem!!");
            }

            BufferedReader myIn = new BufferedReader(new InputStreamReader( myHttp.getInputStream()) ) ;

            while((response = myIn.readLine()) != null)
                json+=response;


        } catch (MalformedURLException e) {
            Log.d("WEATHER", "Malformed URL");
        } catch (IOException e) {
            Log.d("WEATHER", "IOEXception");
        }

        //Log.d("WEATHER", json);
        return json;
    }

    @Override
    protected void onPostExecute(String result) {
        delegate.processFinish(result);
    }


}
