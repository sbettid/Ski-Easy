package skieasy.decy.it.ski_easy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class SlopeView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slope_view);

        TextView title = (TextView) findViewById(R.id.textView7);

        Intent intent = getIntent();
        String tit = intent.getStringExtra("name");
        title.setText(tit);

        

        ListView reviews = (ListView) findViewById(R.id.reviewListView);

        //Array Adapter


    }
}
