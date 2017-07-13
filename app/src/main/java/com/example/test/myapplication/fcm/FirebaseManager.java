package com.example.test.myapplication.fcm;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by home on 7/13/2017.
 */

public class FirebaseManager {
    public static final String TAG = "FirebaseManager";

    public static final String TOKEN_KEY = "FirebaseManagerTokenKey";
    Context context;

    public FirebaseManager(Context context) {
        this.context = context;
    }

    public SharedPreferences getSharedPref(Context context){
        return context.getSharedPreferences(context.getPackageName(),Context.MODE_PRIVATE);
    }

    public String getValueByKey(String key){
        SharedPreferences sharedPref = getSharedPref(context);
        return sharedPref.getString(key, null);
    }

    public void setValueByKey( String key, String value){
        SharedPreferences sharedPref = getSharedPref(context);
        sharedPref.edit().putString(key, value).apply();
    }
}
