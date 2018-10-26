package com.houseofivy.docket;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class
MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "FCM Service";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Log.d(TAG,"From: " + remoteMessage.getFrom());
        Log.d(TAG,"Message: " + remoteMessage.getNotification().getBody());
        notifyUser(remoteMessage.getFrom(),remoteMessage.getNotification().getBody());
    }

    public void notifyUser(String from,String notification){
        MyNotificationManager myNotificationManager = new MyNotificationManager(getApplicationContext());
        myNotificationManager.showNotification(from,notification,new Intent(getApplicationContext(),timeTable.class));
    }
}
