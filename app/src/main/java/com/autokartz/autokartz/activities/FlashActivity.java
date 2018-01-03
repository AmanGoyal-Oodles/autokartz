package com.autokartz.autokartz.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.autokartz.autokartz.R;

public class FlashActivity extends AppCompatActivity {


    private static final int DELAY=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_flash);

        //delay in ms
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(FlashActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        }, DELAY);
    }
}
