package skieasy.decy.it.ski_easy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AreaView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_view);


        TextView title = (TextView) findViewById(R.id.areaTitle);
        Intent current = getIntent();
        String areaName = current.getStringExtra("name");
        title.setText(areaName);
    }
}
