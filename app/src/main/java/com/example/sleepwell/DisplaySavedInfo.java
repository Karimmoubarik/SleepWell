package com.example.sleepwell;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.time.LocalTime;
import java.util.Calendar;

public class DisplaySavedInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_saved_info);

        Intent intent = getIntent();
        int sleep_amount = intent.getIntExtra(Input_Activity.SLEEP_AMOUNT, 0);
        int hours = intent.getIntExtra(Input_Activity.HOURS, 0);
        int minutes = intent.getIntExtra(Input_Activity.MINUTES, 0);

        Log.i("SleepWell", Integer.toString(sleep_amount));


        TextView textView = findViewById(R.id.textView5);
        TextView tv = findViewById(R.id.textView6);
        TextView tv3 = findViewById(R.id.textView11);


        String hour = String.format("%02d",(hours));
        String minute = String.format("%02d",(minutes));
        textView.setText(Integer.toString(sleep_amount));
        tv.setText((hours)+":"+(minutes));
        LocalTime l1 = LocalTime.parse(hour+":"+minute);
      //  Log.i("SleepWell", l1.minusHours(sleep_amount).toString());
        tv3.setText(l1.minusHours(sleep_amount).toString());

        }

    }


