package com.cbule.tuya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.cbule.customview.R;

public class TaYaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        TaYaView taYaView = new TaYaView(TaYaActivity.this,displayMetrics.widthPixels,displayMetrics.heightPixels);
        setContentView(taYaView);
    }
}
