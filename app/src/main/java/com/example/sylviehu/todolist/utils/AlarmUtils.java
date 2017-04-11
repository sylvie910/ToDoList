package com.example.sylviehu.todolist.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.example.sylviehu.todolist.AlarmReceiver;

import java.util.Calendar;
import java.util.Date;

public class AlarmUtils {
    public static void setAlarm(@NonNull Context context, @NonNull Date date) {
        Calendar c = Calendar.getInstance();
        if (date.compareTo(c.getTime()) < 0) {
            return;
        }

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(context, AlarmReceiver.class);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.set(AlarmManager.RTC_WAKEUP, date.getTime(), alarmIntent);
    }
}
