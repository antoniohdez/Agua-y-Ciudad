package com.example.antonioreyes.aguas;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class Deslaves extends ActionBarActivity {

    public String center;
    EditText lugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        center = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_NEW);
        setContentView(R.layout.activity_contaminacion_agua);
        setContentView(R.layout.activity_deslaves);
        lugar = (EditText) findViewById(R.id.editText3);
        lugar.setText(center);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_deslaves, menu);
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

    public void regresaReportes1(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}