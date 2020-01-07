package com.frontiertechnologypartners.changelang;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;


public class PreferenceUtils {

    private SharedPreferences prefs;
    private SharedPreferences.Editor prefsEditor;

    PreferenceUtils(Context mContext) {
        prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        prefsEditor = prefs.edit();
    }

    private SharedPreferences getPrefs() {
        return prefs;
    }

    private SharedPreferences.Editor getPrefsEditor() {
        return prefsEditor;
    }

    void toPreference(String key, String value) {
        getPrefsEditor().putString(key, value);
        getPrefsEditor().commit();
    }

    String fromPreference(String key, String value) {
        return getPrefs().getString(key, value);
    }

    void toPreference(String key, boolean value) {
        getPrefsEditor().putBoolean(key, value);
        getPrefsEditor().commit();
    }

    boolean fromPreference(String key, boolean value) {
        return getPrefs().getBoolean(key, value);
    }

    void toPreference(String key, int value) {
        getPrefsEditor().putInt(key, value);
        getPrefsEditor().commit();
    }

    int fromPreference(String key, int value) {
        return getPrefs().getInt(key, value);
    }

    void clearPreferences() {
        getPrefsEditor().clear();
        getPrefsEditor().commit();
    }


}