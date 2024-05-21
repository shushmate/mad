package com.example.batteryprogress;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ProgressBar pb;
    TextView t;
    BroadcastReceiver b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb=findViewById(R.id.pb);
        t=findViewById(R.id.text);
        b=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
                pb.setProgress(level);
                t.setText("Battery progress: "+level);
                ConstraintLayout c = findViewById(R.id.c);
                if(level>60){
                    c.setBackgroundColor(Color.GREEN);
                }
                else if(level>20){
                    c.setBackgroundColor(Color.BLUE);
                }
                else{
                    c.setBackgroundColor(Color.RED);
                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(b,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(b);
    }
}