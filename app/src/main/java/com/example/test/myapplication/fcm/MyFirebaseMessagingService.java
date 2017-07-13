package com.example.test.myapplication.fcm;


import android.util.Log;
import android.widget.Toast;

import com.example.test.myapplication.bus.PushNotificationBus;
import com.example.test.myapplication.pojo.pushonotification.PushContainer;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;

/**
 * Created by home on 7/13/2017.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "FCM Service";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // TODO: Handle FCM messages here.
        // If the application is in the foreground handle both data and notification messages here.
        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated.
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "Notification Message Body: " + remoteMessage.getNotification().getBody());
        //Toast.makeText(this, "Received push notification: "+remoteMessage.getNotification().getBody(), Toast.LENGTH_LONG).show();

        try {
            PushContainer pushContainer = new Gson().fromJson(remoteMessage.getNotification().getBody(), PushContainer.class);
            PushNotificationBus.sendEvent(pushContainer);
        }catch (Exception e){
            e.printStackTrace();
            Log.d(TAG, "onMessageReceived: error parsing json from push notification");
        }
    }
}
