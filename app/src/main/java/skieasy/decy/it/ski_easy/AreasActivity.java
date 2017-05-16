package skieasy.decy.it.ski_easy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AreasActivity extends AppCompatActivity {

    private TextView mTextMessage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areas);

         BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        //mTextMessage.setText(R.string.title_home);
                        startActivity(new Intent(AreasActivity.this, HomePage.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        return true;
                    case R.id.navigation_dashboard:
                        //mTextMessage.setText(R.string.title_dashboard);
                        return true;
                    case R.id.navigation_notifications:
                        //mTextMessage.setText(R.string.title_notifications);
                        startActivity(new Intent(AreasActivity.this, ProfileActivity.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        return true;
                }
                return false;
            }

        };

        ArrayList<String> listOfAreas = new ArrayList<String>();
        final ListView areas = (ListView) findViewById(R.id.areaView);

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



    areas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Object obj = areas.getItemAtPosition(position);
            String area = (String) obj;

            Intent intent = new Intent(AreasActivity.this, AreaView.class);
            intent.putExtra("name", area);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);


        }
    });

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listOfAreas);

        areas.setAdapter(myAdapter);



        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_dashboard);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

}
