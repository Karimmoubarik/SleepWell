package com.example.sleepwell;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void button_history_pressed(View view){
        Intent intent = new Intent(this, History_Activity.class);
        startActivity(intent);
    }
    public void button_sleep_pressed(View view){
        Intent intent = new Intent(this, Input_Activity.class);
        startActivity(intent);
    }

}
