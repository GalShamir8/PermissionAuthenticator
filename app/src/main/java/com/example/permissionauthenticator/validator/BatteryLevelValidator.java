package com.example.permissionauthenticator.validator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;

public class BatteryLevelValidator extends Rule {
    private float requiredLevel = 30;
    private BroadcastReceiver batteryInfoReceiver;
    private float currentLevel = 0;

    public BatteryLevelValidator() {
        batteryInfoReceiver = new BroadcastReceiver(){
            @Override
            public void onReceive(Context ctx, Intent intent) {
                int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
                int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
                currentLevel = level * 100 / (float)scale;
            }
        };
    }

    @Override
    public boolean validate(Object... params) {
        return currentLevel >= requiredLevel;
    }
}
