package com.example.permissionauthenticator.validator;

import android.content.Context;
import android.net.wifi.WifiManager;

public class WifiValidator extends Rule {
    private WifiManager wifi;

    public WifiValidator(Context ctx) {
        wifi = (WifiManager)ctx.getSystemService(Context.WIFI_SERVICE);
    }

    @Override
    public boolean validate(Object... params) {
        return wifi.isWifiEnabled();
    }
}
