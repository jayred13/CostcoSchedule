package com.example.costcoschedule;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class PersonalScheduleActivity extends AppCompatActivity {
    private String url = "https://login.costco.com/idp/SSO.saml2";
    Spinner weekSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_schedule);

        weekSpinner = findViewById(R.id.week_spinner);
        //weekSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.week_menu, android.R.layout.simple_dropdown_item_1line);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weekSpinner.setAdapter(adapter);

        getDate();
    }

    public void backButtonClicked(View view){
        startActivity(new Intent(this, MainActivity.class));
    }

    public void sharedSchedulesClicked(View view){
        Toast.makeText(PersonalScheduleActivity.this, "Shared Schedules!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, SharedSchedulesActivity.class));
    }

    public void postingsClicked(View view){
        Toast.makeText(PersonalScheduleActivity.this, "Postings!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, PostingsActivity.class));
    }

    public void employeeSiteClicked(View view){
        Toast.makeText(PersonalScheduleActivity.this, "Employee Site!", Toast.LENGTH_SHORT).show();

        Intent viewPage = new Intent(Intent.ACTION_VIEW);
        viewPage.setData(Uri.parse(url));
        startActivity(viewPage);
    }

    private void getDate(){
        ArrayList<TextView> week = new ArrayList<>(7);
        week.add((TextView) findViewById(R.id.mondayDateText));
        week.add((TextView) findViewById(R.id.tuesdayDateText));
        week.add((TextView) findViewById(R.id.wednesdayDateText));
        week.add((TextView) findViewById(R.id.thursdayDateText));
        week.add((TextView) findViewById(R.id.fridayDateText));
        week.add((TextView) findViewById(R.id.saturdayDateText));
        week.add((TextView) findViewById(R.id.sundayDateText));

        // Get today and clear time of day
        Calendar cal = Calendar.getInstance();

        // get start of this week in milliseconds
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        cal.add(Calendar.DATE, 1);

        for (int i=0; i<7; i++) {
            String day = cal.getTime().toString();
            day = day.substring(0,3) + " - " + day.substring(4,10);
            TextView dayView = week.get(i);
            dayView.setText(day);

            // Day increment
            cal.add(Calendar.DATE, 1);

        }
    }
}
