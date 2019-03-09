package com.example.sleepwell;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;


public class Input_Activity extends AppCompatActivity {
    public static final String SLEEP_AMOUNT = "com.example.sleepwell.SLEEP_AMOUNT";
    public static final String HOURS = "com.example.sleepwell.HOURS";
    public static final String MINUTES = "com.example.sleepwell.MINUTES";
    private static final String CHANNEL_ID = "SleepWellId";

    private TimePicker timePicker1;
    SharedPreferences sPrefs;

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "SleepWell Notification";
            String description = "SleepWell Notifications";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_);
        createNotificationChannel();


        timePicker1 = (TimePicker) findViewById(R.id.timePicker);
        timePicker1.setIs24HourView(true);




    }


    public void saveOnClick (View view){
        Intent intent = new Intent(this, DisplaySavedInfo.class);
        EditText editText = (EditText) findViewById(R.id.sleepAmount);

        String sleepAmount = editText.getText().toString();
        int sleepAmountInt = -1;
        if(!sleepAmount.equals("")) {
            sleepAmountInt = Integer.parseInt(sleepAmount);
        }

        int hours = timePicker1.getHour();
        //String hours_string = Integer.toString(hours);
        int minutes = timePicker1.getMinute();
        //String minutes_string = Integer.toString(minutes);




        sPrefs = getSharedPreferences("PREFS", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sPrefs.edit();
        editor.putInt("sleepAmount", sleepAmountInt);
        editor.apply();
        intent.putExtra(SLEEP_AMOUNT, sleepAmountInt);
        intent.putExtra(HOURS, hours);
        intent.putExtra(MINUTES, minutes);
        if(sleepAmountInt != -1) {
            startActivity(intent);
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("Set sleep amount")
                    .setMessage("Remember to set the sleep amount.")
                    .setNeutralButton(android.R.string.ok, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }



}
