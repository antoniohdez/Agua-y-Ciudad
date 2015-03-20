package com.example.antonioreyes.aguas;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import java.util.Calendar;

public class FaltaAgua extends ActionBarActivity {

    public EditText dateTV;
    public EditText timeTV;
    public EditText placeTV;
    public EditText commentTV;

    private Calendar calendar;
    private int year, month, day, hour, minute;

    private ParseObject p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_falta_agua);

        Intent intent = getIntent();
        String center = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_NEW);

        dateTV = (EditText) findViewById(R.id.dateTV);

        timeTV = (EditText) findViewById(R.id.timeTV);

        placeTV = (EditText) findViewById(R.id.placeTV);
        placeTV.setText(center);

        commentTV = (EditText) findViewById(R.id.commentTV);

        calendar = Calendar.getInstance();

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);

        setDate();

        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

        setTime();

        p = new ParseObject("FaltaAgua");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_falta_agua, menu);
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
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 1) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }else if(id == 2){
            return new TimePickerDialog(this, myTimeListener, hour, minute, false);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener
            = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker arg0, int y, int m, int d) {
            year = y;
            month = m;
            day = d;
            setDate();
        }
    };

    public void setDate(){
        dateTV.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/")
                .append(year));
    }

    public void showDateWidget(View v){
            showDialog(1);
    }

    private TimePickerDialog.OnTimeSetListener myTimeListener =  new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int h, int m) {
            hour = h;
            minute = m;
            setTime();
        }
    };



    public void setTime(){
        timeTV.setText(new StringBuilder().append(hour).append(":").append(minute));
    }

    public void showTimeWidget(View v){
        showDialog(2);
    }

    public void saveReport(View v){
        p.put("reportDate", dateTV.getText().toString());
        p.put("reportTime", timeTV.getText().toString());
        p.put("location", placeTV.getText().toString());
        p.put("comment", commentTV.getText().toString());

        p.saveInBackground(new SaveCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    //Success
                    Toast.makeText(getApplicationContext(), "Save on Parse", Toast.LENGTH_SHORT).show();
                } else {
                    //Error
                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void regresaReportes3(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}