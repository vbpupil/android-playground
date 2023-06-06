package com.vbpupil.salon;

import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;

public class Alarm {
    public Ringtone alarm;

    protected Context applicationContext;

    Alarm(Context context) {
        this.applicationContext = context;
        this.alarm = init();
    }

    public void play() {
        this.alarm.play();
    }

    public void stop(){
        this.alarm.stop();
    }

    public Ringtone init() {
        Uri alarm = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);

        if (alarm == null) {
            alarm = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

            if (alarm == null) {
                alarm = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
            }
        }

        return RingtoneManager.getRingtone(this.applicationContext, alarm);
    }
}
