package skieasy.decy.it.ski_easy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SlopeView extends AppCompatActivity {
    private ImageButton zoom_map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slope_view);
        zoom_map = (ImageButton) findViewById(R.id.expanded_image);

        TextView title = (TextView) findViewById(R.id.textView7);

        Intent intent = getIntent();
        String tit = intent.getStringExtra("name");
        title.setText(tit);

        //zoom_map = (ImageView) findViewById(R.id.expanded_image);
        ImageButton map = (ImageButton) findViewById(R.id.imageButton5);

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "aaaaaa" , Toast.LENGTH_SHORT).show();
                //zoom_map = (ImageButton) findViewById(R.id.expanded_image);
                zoom_map.setVisibility(View.VISIBLE);
            }
        });

        zoom_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zoom_map.setVisibility(View.INVISIBLE);
            }
        });

        

        ListView reviews = (ListView) findViewById(R.id.reviewListView);

        //Array Adapter


    }
}
