package com.vbpupil.salon;

import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;

public class Alarm {
    public Ringtone alarm;

    protected Context context;

    Alarm(Context context){
        this.context = context;
        this.alarm = init();
    }

    public void sound(){
        this.alarm.play();
    }

    public Ringtone init(){
        Uri alarm = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);

        if(alarm == null){
            alarm = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

            if(alarm == null) {
                alarm = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
            }
        }

        return RingtoneManager.getRingtone(this.context, alarm);
    }
}
