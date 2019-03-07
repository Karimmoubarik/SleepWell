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


        TextView textView = findViewById(R.id.textView5);
        TextView tv = findViewById(R.id.textView6);
        TextView tv3 = findViewById(R.id.textView11);



        textView.setText(Integer.toString(sleep_amount));
        tv.setText(Integer.toString(hours)+":"+Integer.toString(minutes));
        LocalTime l1 = LocalTime.parse(Integer.toString(hours)+":"+Integer.toString(minutes));
        Log.i("SleepWell", l1.minusHours(sleep_amount).toString());
        tv3.setText(l1.minusHours(sleep_amount).toString());

        /*nukkumaan = hours1 - sleep_amount1;
        if (nukkumaan < 0){
            nukkumaan = nukkumaan + 24;
        }

        if (nukkumaan == 0){

            tv3.setText( "0"+Integer.toString(nukkumaan)+ " :" + minutes);

        }
        if(  minutes1 < 10)
        {
            tv3.setText( Integer.toString(nukkumaan)+ " :0" + minutes);

        }
        if (nukkumaan == 0 && minutes1 < 10){

            tv3.setText( Integer.toString(nukkumaan)+ " :0" + minutes);


        }
        else

        tv3.setText("0"+Integer.toString(nukkumaan) + " :0" + minutes);
*/

        }

    }


