package skieasy.decy.it.ski_easy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.Iterator;

public class AreaView extends AppCompatActivity implements AsyncResponse {

    ImageView weatherImg;
    TextView temperature;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_view);

        //Get area
        TextView title = (TextView) findViewById(R.id.areaTitle);
        Intent current = getIntent();
        final String areaName;
        areaName = current.getStringExtra("name");
        title.setText(areaName);


       Object obj =  new WeatherForecasts(this).execute(areaName);


        weatherImg = (ImageView) findViewById(R.id.imageView);
        temperature = (TextView) findViewById(R.id.textView6);

        Button slopesList = (Button) findViewById(R.id.buttonSlopesList);
        slopesList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AreaView.this, SlopesListView.class);
                intent.putExtra("name", areaName);
                startActivity(intent);

            }
        });


    }

    @Override
    public void processFinish(String output) {
       // Toast.makeText(getApplicationContext(), output , Toast.LENGTH_SHORT).show();
        //PARSING

        JSONParser myParser = new JSONParser();
       // Log.d("WEATHER", output);
        try{
            Object obj = myParser.parse(output);

            JSONObject jsonObj = (JSONObject) obj;

            //Log.d("WEATHER", "JSON: " + jsonObj.toJSONString());

            JSONArray weather = (JSONArray) jsonObj.get("weather");

            Iterator<String> WIter= weather.iterator();

            while(WIter.hasNext()){

                Object o = WIter.next();

                JSONObject oj = (JSONObject) o;

                String currentWeather = (String) oj.get("main");
                Log.d("WEATHER", currentWeather);

                if(currentWeather.toLowerCase().contains("clear") ){
                    weatherImg.setImageResource(R.mipmap.sunny);
                } else if(currentWeather.toLowerCase().contains("rain") ){
                    weatherImg.setImageResource(R.mipmap.rainy);
                } else if(currentWeather.toLowerCase().contains("snow") ){
                    weatherImg.setImageResource(R.mipmap.snow);
                } else
                    weatherImg.setImageResource(R.mipmap.cloudy);




            }
            //Log.d("WEATHER", "JSON:" + z.toJSONString());


            JSONObject main = (JSONObject) jsonObj.get("main");

            double temp = (double) main.get("temp");

            temp = temp - 273.15;
            DecimalFormat formatter = new DecimalFormat("##.##");
            temperature.setText(formatter.format(temp) + " °C");
        }catch(Exception ex){
            Log.d("WEATHER", "EXCEPTION");
        }
    }
}