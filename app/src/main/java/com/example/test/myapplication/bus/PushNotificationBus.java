package com.example.test.myapplication.bus;

import com.example.test.myapplication.pojo.pushonotification.PushContainer;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by home on 7/13/2017.
 */

public class PushNotificationBus {
    PushContainer pushContainer;

    public PushNotificationBus(PushContainer pushContainer) {
        this.pushContainer = pushContainer;
    }

    public static void sendEvent(PushContainer pushContainer){
        EventBus.getDefault().post(new PushNotificationBus(pushContainer));
    }

    public PushContainer getPushContainer() {
        return pushContainer;
    }

    public void setPushContainer(PushContainer pushContainer) {
        this.pushContainer = pushContainer;
    }
}
