package skieasy.decy.it.ski_easy;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SlopeView extends AppCompatActivity {
    private ImageButton zoom_map;
     ArrayList<String[]>  values;
    ListView reviews;

    public SlopeView() {
        values = new ArrayList<String[]>();
        values.add(new String[] {"cremo", "Wonderful slope!", "5"});
        values.add(new String[] {"yuri", "Perfect snow!", "4"});
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("DEBUG", values.toArray().toString());
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

        

        reviews = (ListView) findViewById(R.id.reviewListView);

        //Array Adapter



        //Array Adapter

        myAdapter ad = new myAdapter(getApplicationContext(), values);

        reviews.setAdapter(ad);



        ImageButton addReview = (ImageButton) findViewById(R.id.imageButton);
        addReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(SlopeView.this);
               builder.setTitle("Add your opinion");
                final LayoutInflater inflater = getLayoutInflater();
                final View myView = inflater.inflate(R.layout.new_review, null);
                builder.setView(myView);
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText edit = (EditText) myView.findViewById(R.id.editText);
                        String text = edit.getText().toString();
                        RatingBar bar = (RatingBar) myView.findViewById(R.id.ratingBar2);
                        Float numStars = bar.getRating();
                        values.add(new String[] {"davide",text, String.valueOf(numStars)});

                        myAdapter ad = new myAdapter(getApplicationContext(), values);

                        reviews.setAdapter(ad);

                    }
                });
                builder.show();
            }
        });
    }
}
