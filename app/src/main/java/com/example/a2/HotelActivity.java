package com.example.a2;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

public class HotelActivity extends FragmentActivity {
    static String[] mTitleArray;
    static String[] mQuoteArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_hotel);

        mTitleArray = getResources().getStringArray(R.array.Titles);
        //mQuoteArray = getResources().getStringArray(R.array.Quotes);
        setContentView(R.layout.activity_hotel);
    }

}
