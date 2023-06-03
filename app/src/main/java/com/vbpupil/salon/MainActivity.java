package com.vbpupil.salon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        String name = intent.getStringExtra("timer_name");
        String duration = intent.getStringExtra("timer_duration");

        Log.d("salonLog", "Name: " + name);
        Log.d("salonLog", "Duration: " + duration);
    }

    public void viewTimers(View v){
        Intent createTimerIntent = new Intent(MainActivity.this, TimersActivity.class);

        MainActivity.this.startActivity(createTimerIntent);
    }

}