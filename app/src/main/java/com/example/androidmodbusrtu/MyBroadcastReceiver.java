package com.example.androidmodbusrtu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyBroadcastReceiver extends BroadcastReceiver {
    //private static final String TAG = "MyBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {

        if("com.darryncampbell.cordova.plugin.intent.ACTION".equals(intent.getAction().toString()))
        {
            String received = intent.getExtras().getString("test");
            GlobalVar globalVar = (GlobalVar) context.getApplicationContext();
            globalVar.setString1(received);
        }
        else{
            GlobalVar globalVar = (GlobalVar) context.getApplicationContext();
            globalVar.setString1("did not work");
        }

    }

}