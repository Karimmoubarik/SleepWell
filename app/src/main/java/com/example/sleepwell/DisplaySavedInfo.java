package com.example.sleepwell;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
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

        //Notification
        Intent notifyIntent = new Intent(this,MyReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast
                (this, 1, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,  System.currentTimeMillis(),
                1000 * 60 * 60 * 24, pendingIntent);
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.set(Calendar.HOUR_OF_DAY, hours);
        cal.set(Calendar.MINUTE, minutes);
        cal.set(Calendar.SECOND, 0);
        if (cal.before(Calendar.getInstance())) {
            cal.add(Calendar.DATE, 1);
        }
        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),pendingIntent);
        }

    }


