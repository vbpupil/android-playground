package com.vbpupil.salon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TimersActivity extends AppCompatActivity {
    public int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timers);

        this.handleStartTimer();
    }

    public void handleStartTimer(){
        Button startTimerButton = (Button) findViewById(R.id.startTimer);
        TextView timerDisplay = (TextView) findViewById(R.id.timerInput);

        startTimerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountDownTimer(5000, 1000){
                    public void onTick(long millisUntilFinished){
                        timerDisplay.setText(String.valueOf(counter));
                        counter++;
                    }
                    public  void onFinish(){
                        timerDisplay.setText("FINISH!!");
                        Alarm a = new Alarm(getApplicationContext());
                        a.sound();
                    }
                }.start();
            }
        });
    }

    public void createTimer(View v){
        EditText nameInput = findViewById(R.id.timerName);
        EditText durationInput = findViewById(R.id.timerInput);

        Toast.makeText(this, nameInput.getText() + " Created", Toast.LENGTH_SHORT).show();

        Intent timerSummary = new Intent(this, MainActivity.class);

        timerSummary.putExtra("timer_name", nameInput.getText());
        timerSummary.putExtra("timer_duration", durationInput.getText());

        this.startActivity(timerSummary);
    }
}