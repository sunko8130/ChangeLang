package com.frontiertechnologypartners.changelang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends BaseActivity {
    Button goNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        goNext = findViewById(R.id.go_next);
        goNext.setOnClickListener(view -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, new ChangeLangFragment())
                    .commit();
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.frame, new ChangeLangFragment())
                .commit();

        Log.e("refresh fargment","onCreate");
    }
}
