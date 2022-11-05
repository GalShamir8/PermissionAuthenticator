package com.example.permissionauthenticator.validator;

import android.content.Context;
import android.net.wifi.WifiManager;

public class WifiValidator extends Rule {
    private Context ctx;

    public WifiValidator(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public boolean validate(Object... params) {
        return ((WifiManager)ctx.getSystemService(Context.WIFI_SERVICE)).isWifiEnabled();
    }
}
