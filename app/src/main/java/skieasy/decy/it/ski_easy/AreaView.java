package skieasy.decy.it.ski_easy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class AreaView extends AppCompatActivity implements AsyncResponse {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_view);

        //Get area
        TextView title = (TextView) findViewById(R.id.areaTitle);
        Intent current = getIntent();
        String areaName = current.getStringExtra("name");
        title.setText(areaName);


       Object obj =  new WeatherForecasts(this).execute();


    }

    @Override
    public void processFinish(String output) {
       // Toast.makeText(getApplicationContext(), output , Toast.LENGTH_SHORT).show();
        //PARSING
    }
}