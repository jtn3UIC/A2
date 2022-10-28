package com.example.a2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    class MyReciever extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (Objects.equals(action, "hotel")) {
               System.out.println("HOTEL");
            } else if (Objects.equals(action, "attract")) {
                System.out.println("ATTRACT");
            }
        }
    }
    BroadcastReceiver mReceiver;
    IntentFilter hFilter;
    IntentFilter aFilter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mReceiver = new MyReciever();
        hFilter = new IntentFilter("hotel");
        aFilter = new IntentFilter("attract");
        registerReceiver(mReceiver,hFilter,"edu.uic.cs478.fall22.mp3",null);
        registerReceiver(mReceiver,aFilter,"edu.uic.cs478.fall22.mp3",null);


    }
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
    }
}