package com.example.permissionauthenticator.validator;

import android.content.Context;
import android.os.BatteryManager;


public class BatteryLevelValidator extends Rule {
    private static final int REQUIRED_BATTERY_LEVEL = 30;
    private BatteryManager batteryManager;

    public BatteryLevelValidator(Context ctx) {
        batteryManager = (BatteryManager)ctx.getSystemService(Context.BATTERY_SERVICE);
    }

    @Override
    public boolean validate() {
        int currentBatteryLevel = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);

        return currentBatteryLevel >= REQUIRED_BATTERY_LEVEL;
    }
}
