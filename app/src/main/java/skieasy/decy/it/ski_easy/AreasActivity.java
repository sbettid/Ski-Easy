package skieasy.decy.it.ski_easy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AreasActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    startActivity(new Intent(AreasActivity.this, HomePage.class));
                    overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    //mTextMessage.setText(R.string.title_notifications);
                    startActivity(new Intent(AreasActivity.this, ProfileActivity.class));
                    overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areas);

        ArrayList<String> listOfAreas = new ArrayList<String>();
        ListView areas = (ListView) findViewById(R.id.areaView);

        listOfAreas.add("Cortina D'Ampezzo");
        listOfAreas.add("Plan De Corones");
        listOfAreas.add("Alta Badia");
        listOfAreas.add("Val Gardena");
        listOfAreas.add("Alpe di Siusi");
        listOfAreas.add("Val di Fassa");
        listOfAreas.add("Carezza");
        listOfAreas.add("Arabba");
        listOfAreas.add("Marmolada");
        listOfAreas.add("Tre Cime");
        listOfAreas.add("Val di Fiemme");
        listOfAreas.add("Obereggen");
        listOfAreas.add("Passo Rolle");
        listOfAreas.add("Valle Isarco");
        listOfAreas.add("Alpe Lusia");
        listOfAreas.add("Civetta");





        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listOfAreas);

        areas.setAdapter(myAdapter);


        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_dashboard);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
