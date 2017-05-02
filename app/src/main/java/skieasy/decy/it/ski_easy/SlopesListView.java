package skieasy.decy.it.ski_easy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SlopesListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slopes_list_view);


        Intent intent = getIntent();
        String areaName = intent.getStringExtra("name");

        TextView area = (TextView) findViewById(R.id.textView5);
        area.setText(areaName);


        ArrayList<String> slopesList = new ArrayList<String>();


        slopesList.add("Falzarego - Lagazuoi");
        slopesList.add("Col Gallina");
        slopesList.add("5 Torri");
        slopesList.add("Fedare - Forcella Nuvolau");
        slopesList.add("Olimpa");
        slopesList.add("Alpe Potor - Nuvolau");
        slopesList.add("Fedare - Croda Negra");
        slopesList.add("Baby Socrepes");
        slopesList.add("Gilardon/Roncato");
        slopesList.add("Roncato - Socrepes");
        slopesList.add("Roncato Festis");
        slopesList.add("Rumerlo/Duca D'Aosta");
        slopesList.add("Colfiere/Col Drusciè");
        slopesList.add("Cortina - Col Drusciè");
        slopesList.add("Col Druscièì/ Ra Valles");
        slopesList.add("Ra Valles/ Cima Tofana");
        slopesList.add("Pian Ra Valles");
        slopesList.add("Cacciatori");
        slopesList.add("Funivia Faloria");
        slopesList.add("San Marco");
        slopesList.add("Ansiei");


        final ListView slopesListView = (ListView) findViewById(R.id.list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, slopesList);

        slopesListView.setAdapter(adapter);

        slopesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SlopesListView.this, SlopeView.class);
                String slope = (String) slopesListView.getItemAtPosition(position);
                intent.putExtra("name", slope);
                startActivity(intent);
            }
        });
    }
}
