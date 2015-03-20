package com.example.antonioreyes.aguas;


import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class Inundaciones extends ActionBarActivity implements AdapterView.OnItemClickListener,
        AdapterView.OnItemSelectedListener{

    public Spinner s;
    public String center;
    EditText lugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        center = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_NEW);
        setContentView(R.layout.activity_inundaciones);
        lugar = (EditText) findViewById(R.id.editText3);
        lugar.setText(center);

        s = (Spinner) findViewById(R.id.spinner);

        String[] second = { "Calle: inundación baja",
                "Banqueta: inundación media",
                "Casa: inundación alta"
        };

        ArrayAdapter<String> a = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                second);

        s.setAdapter(a);

        //s.setOnItemClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inundaciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, position + "1", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, position + "2", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void regresaReportes7(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}