package com.frontiertechnologypartners.changelang;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.mmtextview.components.MMButton;
import org.mmtextview.components.MMTextView;

import java.util.Locale;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class MainActivity extends BaseActivity {

    private Button btnMyan, btnEng;
    private TextView tvHello,tvHelloWorld;
    PreferenceUtils prefs;

//    @Override
//    protected void attachBaseContext(Context newBase) {
//        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs = new PreferenceUtils(this);
        //init views
        btnMyan = findViewById(R.id.btn_myanmar);
        btnEng = findViewById(R.id.btn_english);
        tvHello = findViewById(R.id.tv_hello);
        tvHelloWorld = findViewById(R.id.tv_hello_world);
        prefs = new PreferenceUtils(this);
        Log.e("onCreate", "onCreate");

        //click
        btnMyan.setOnClickListener(view -> setNewLocale("my"));

        btnEng.setOnClickListener(view -> setNewLocale("en"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            // launch settings activity
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            finish();
//            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String defLanguage = Locale.getDefault().getLanguage();
        tvHello.setText(String.format("Locale.getDefault() - %s", defLanguage));
    }

    private void setNewLocale(String language) {
        App.localeManager.persistLanguage(language);

        finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
        overridePendingTransition(0, 0);
    }
}
