package com.andre.appminhaideia.controller;

import android.util.Log;

import com.andre.appminhaideia.core.AppUtil;

public class ClienteController {

    String appVersion;

    public ClienteController() {

        this.appVersion = AppUtil.aplicationVersion();
        Log.i(AppUtil.TAG, "Cliente controller: App version ===>" + appVersion);

    }

}
