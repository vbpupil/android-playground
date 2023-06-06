package com.vbpupil.salon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TimersActivity extends AppCompatActivity {
    public int counter;

    public int countDown;
    Button startTimerButton;
    Button stopAlarmButton;
    TextView timerCountdown;
    TextView timerDescription;
    Alarm alarm;

    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timers);

        this.setUp();
    }

    void setUp() {
        this.startTimerButton = (Button) findViewById(R.id.startTimer);
        this.stopAlarmButton = (Button) findViewById(R.id.stopAlarm);
        this.timerCountdown = (TextView) findViewById(R.id.timerInput);
        this.timerDescription = (TextView) findViewById(R.id.timerName);
        this.alarm = new Alarm(getApplicationContext());

        startTimerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
            }
        });

        stopAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAlarm();
            }
        });
    }

    private void startTimer() {
        this.countDown = Integer.valueOf(this.timerCountdown.getText().toString());
        this.timerCountdown.setEnabled(false);
        this.timerDescription.setEnabled(false);

        counter = this.countDown;
       this.timer = new CountDownTimer(countDown * 1000, 1000) {
            public void onTick(long millisUntilFinished) {
                timerCountdown.setText(String.valueOf(counter));
                counter--;
            }

            public void onFinish() {
                handleAlarm();
            }
        }.start();
    }

    private void handleAlarm() {
        Toast.makeText(this, this.timerDescription.getText() + " (" + this.countDown + " seconds)" + " has finished!", Toast.LENGTH_LONG).show();
        this.alarm.play();
    }

    private void clearAlarm() {
        this.timer.cancel();
        this.alarm.stop();
        this.timerCountdown.setEnabled(true);
        this.timerDescription.setEnabled(true);
    }
}