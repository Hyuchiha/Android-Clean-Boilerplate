package com.hyuchiha.boilerplate.app.common.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import java.util.List;

/**
 * Created by hyuchiha on 24/07/17.
 */
public class NotificationUtil {

    private static final String TAG = NotificationUtil.class.getSimpleName();

    /**
     * Create a Notification when clicked open an intent
     *
     * @param context
     * @param id
     * @param intent
     * @param smallIcon
     * @param contentTitle
     * @param contentText
     */
    public static void create(Context context,
                              int id,
                              Intent intent,
                              int smallIcon,
                              String contentTitle,
                              String contentText,
                              int priority){
        NotificationManager manager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        // Intent para disparar o broadcast
        PendingIntent p = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        // DO NOT ever call getBaseContext() unless you know what you're doing. "this" or "getApplicationContext() is perfect. Google the difference.
        String ringtonePreference = prefs.getString("key_notifications_new_message_ringtone", null);
        // The key of preference was "@string/ringtonePref" which is useless since you're hardcoding the string here anyway.
        Uri ringtoneuri = ringtonePreference != null ? Uri.parse(ringtonePreference) : null;

        // Creamos la notificacion
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentIntent(p)
                .setContentTitle(contentTitle)
                .setContentText(contentText)
                .setSmallIcon(smallIcon)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(contentText))
                .setColor(context.getResources().getColor(android.R.color.black))
                .setPriority(priority)
                .setDefaults(Notification.DEFAULT_ALL)
                .setAutoCancel(true);

        if (ringtoneuri != null) {
            builder.setSound(ringtoneuri);
        }

        // Dispara la notificacion
        Notification n = builder.build();
        manager.notify(id, n);

        Log.d(TAG,"Notification created");
    }

    /**
     * Create a Notification when clicked open an intent
     *
     * @param context
     * @param id
     * @param parentIntent
     * @param childrenIntent
     * @param smallIcon
     * @param contentTitle
     * @param contentText
     */
    public static void createWithChildrenView(Context context,
                              int id,
                              Intent parentIntent,
                              Intent childrenIntent,
                              int smallIcon,
                              String contentTitle,
                              String contentText,
                              int priority){
        NotificationManager manager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        // Intent para disparar o broadcast
        PendingIntent p = PendingIntent.getActivities(context, 0, new Intent[] { parentIntent, childrenIntent }, PendingIntent.FLAG_UPDATE_CURRENT);

        // Creamos la notificacion
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentIntent(p)
                .setContentTitle(contentTitle)
                .setContentText(contentText)
                .setSmallIcon(smallIcon)
                .setColor(context.getResources().getColor(android.R.color.black))
                .setPriority(priority)
                .setDefaults(Notification.DEFAULT_ALL)
                .setAutoCancel(true);

        // Dispara la notificacion
        Notification n = builder.build();
        manager.notify(id, n);

        Log.d(TAG,"Notification created");
    }

    /**
     * Create a Notification with expanded view, when clicked open an intent
     *
     * @param context
     * @param id
     * @param intent
     * @param smallIcon
     * @param contentTitle
     * @param contentText
     * @param priority
     * @param expandedTitle
     * @param lines
     */
    public static void createExpandedNotification(Context context,
                                                  int id,
                                                  Intent intent,
                                                  int smallIcon,
                                                  String contentTitle,
                                                  String contentText,
                                                  int priority,
                                                  String expandedTitle,
                                                  List<String> lines){
        NotificationManager manager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        // Intent para disparar o broadcast
        PendingIntent p = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.InboxStyle styleExpanded = new NotificationCompat.InboxStyle();

        styleExpanded.setBigContentTitle(expandedTitle);

        for(String line: lines){
            styleExpanded.addLine(line);
        }

        // Creamos la notificacion
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentIntent(p)
                .setContentTitle(contentTitle)
                .setContentText(contentText)
                .setSmallIcon(smallIcon)
                .setColor(context.getResources().getColor(android.R.color.black))
                .setStyle(styleExpanded)
                .setPriority(priority)
                .setDefaults(Notification.DEFAULT_ALL)
                .setAutoCancel(true);

        // Dispara la notificacion
        Notification n = builder.build();
        manager.notify(id, n);

        Log.d(TAG,"Notification created");
    }

    /**
     * Create a stack Notification with and asociated Intent when clicked
     *
     * @param context
     * @param id
     * @param groupId
     * @param intent
     * @param smallIcon
     * @param contentTitle
     * @param contentText
     */
    public static void createStackNotification(Context context,
                                               int id,
                                               String groupId,
                                               Intent intent,
                                               int smallIcon,
                                               String contentTitle,
                                               String contentText,
                                               int priority) {
        NotificationManager manager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        // Intent para disparar o broadcast
        PendingIntent p = intent != null ? PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT) : null;

        // Creamos la notificacion
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentIntent(p)
                .setContentTitle(contentTitle)
                .setContentText(contentText)
                .setSmallIcon(smallIcon)
                .setColor(context.getResources().getColor(android.R.color.black))
                .setPriority(priority)
                .setDefaults(Notification.DEFAULT_ALL)
                .setGroup(groupId)
                .setAutoCancel(true);

        // Dispara la notificacion
        Notification n = builder.build();
        manager.notify(id, n);

        Log.d(TAG,"Stackable Notification created");
    }

    /**
     * Create a simple Notification in the status bar
     *
     * @param context
     * @param smallIcon
     * @param contentTitle
     * @param contentText
     */
    public static void createSimple(Context context,
                                    int smallIcon,
                                    String contentTitle,
                                    String contentText,
                                    int priority) {
        NotificationManager manager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        // Creamos la notificacion
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentTitle(contentTitle)
                .setContentText(contentText)
                .setSmallIcon(smallIcon)
                .setColor(context.getResources().getColor(android.R.color.black))
                .setPriority(priority)
                .setDefaults(Notification.DEFAULT_ALL)
                .setAutoCancel(true);

        // Dispara la notificacion
        Notification n = builder.build();
        manager.notify(0, n);

        Log.d(TAG,"Simple Notification created");
    }

    /**
     * Dismiss the Notification with the same id
     *
     * @param context
     * @param id
     */
    public static void cancel(Context context, int id) {
        NotificationManagerCompat nm = NotificationManagerCompat.from(context);
        nm.cancel(id);
    }

    /**
     * Dismiss all the current notifications
     *
     * @param context
     */
    public static void cancelAll(Context context) {
        NotificationManagerCompat nm = NotificationManagerCompat.from(context);
        nm.cancelAll();
    }

}
