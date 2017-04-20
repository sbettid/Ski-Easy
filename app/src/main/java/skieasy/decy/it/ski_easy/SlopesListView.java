package skieasy.decy.it.ski_easy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SlopesListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slopes_list_view);


        Intent intent = getIntent();
        String areaName = intent.getStringExtra("name");

        TextView area = (TextView) findViewById(R.id.textView5);
        area.setText(areaName);
    }
}
