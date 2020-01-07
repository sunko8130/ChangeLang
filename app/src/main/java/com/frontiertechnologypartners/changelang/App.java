package com.frontiertechnologypartners.changelang;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;

public class App extends Application {

    public static final String TAG = "App";

    // for the sake of simplicity. use DI in real apps instead
    public static LocaleManager localeManager;

    @Override
    public void onCreate() {
        super.onCreate();
        //font override
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/pyidaungsu.ttf");
        TypefaceUtil.overrideFont(getApplicationContext(), "MONOSPACE", "fonts/SmartZawgyi.ttf");
        TypefaceUtil.overrideFont(getApplicationContext(), "NORMAL", "fonts/mm3.ttf");
        TypefaceUtil.overrideFont(getApplicationContext(), "SANS_SERIF", "fonts/helvetca.ttf");
    }

    @Override
    protected void attachBaseContext(Context base) {
        localeManager = new LocaleManager(base);
        super.attachBaseContext(localeManager.setLocale(base));
        Log.d(TAG, "attachBaseContext");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        localeManager.setLocale(this);
        Log.d(TAG, "onConfigurationChanged: " + newConfig.locale.getLanguage());
    }
}