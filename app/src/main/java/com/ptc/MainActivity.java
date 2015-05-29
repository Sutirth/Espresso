package com.ptc;


import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.squareup.timessquare.CalendarPickerView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
        private CalendarPickerView  calendar;
       private static final String TAG ="PTC";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Calendar nextYear = Calendar.getInstance();
//        nextYear.add(Calendar.YEAR, 1);
//
//        calendar = (CalendarPickerView)findViewById(R.id.calendar_view);
//        Date today = new Date();
//        calendar.init(today, nextYear.getTime())
//                .withSelectedDate(today)
//                .inMode(CalendarPickerView.SelectionMode.RANGE);
//        calendar.highlightDates(getHolidays());
        Button btnSubmit = (Button)findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    private ArrayList<Date> getHolidays(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
        String dateInString = "21-05-2015";
        Date date = null;
        try {
            date = sdf.parse(dateInString);
            Log.d(TAG,"date");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ArrayList<Date> holidays = new ArrayList<>();
        holidays.add(date);
        return holidays;
    }
}
