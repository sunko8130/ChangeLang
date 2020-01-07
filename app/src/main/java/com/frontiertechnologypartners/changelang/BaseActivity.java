package com.frontiertechnologypartners.changelang;

import android.content.Context;
import android.util.Log;

import org.mmtextview.MMFontUtils;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    private static final String TAG = "BaseActivity";

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(App.localeManager.setLocale(newBase));
        //init mmFont for samsung
//        MMFontUtils.initMMTextView(this);
        Log.d(TAG, "attachBaseContext");
    }



}
