package skieasy.decy.it.ski_easy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    private TextView mTextMessage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button first = (Button) findViewById(R.id.button);
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, SlopeView.class);
                String slope = (String) first.getText();
                intent.putExtra("name", slope);
                startActivity(intent);
            }
        });

        final Button second = (Button) findViewById(R.id.button2);
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, SlopeView.class);
                String slope = (String) second.getText();
                intent.putExtra("name", slope);
                startActivity(intent);

            }
        });

        final Button third = (Button) findViewById(R.id.button3);
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, SlopeView.class);
                String slope = (String) third.getText();
                intent.putExtra("name", slope);
                startActivity(intent);

            }
        });

        final Button fourth = (Button) findViewById(R.id.button4);
        fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, SlopeView.class);
                String slope = (String) fourth.getText();
                intent.putExtra("name", slope);
                startActivity(intent);

            }
        });

        final Button fifth = (Button) findViewById(R.id.button5);
        fifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, SlopeView.class);
                String slope = (String) fifth.getText();
                intent.putExtra("name", slope);
                startActivity(intent);

            }
        });

        BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        //mTextMessage.setText(R.string.title_home);
                        return true;
                    case R.id.navigation_dashboard:
                        //mTextMessage.setText(R.string.title_dashboard);
                        startActivity(new Intent(HomePage.this, AreasActivity.class));
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

                        return true;
                    case R.id.navigation_notifications:
                        startActivity(new Intent(HomePage.this, ProfileActivity.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        //mTextMessage.setText(R.string.title_notifications);
                        return true;
                }
                return false;
            }

        };


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_home);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
