package com.example.a2;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class HotelActivity extends AppCompatActivity {
    public static String hurl = null;
    static String[] mTitleArray;
    static String[] mQuoteArray;
    FragmentManager fragmentManager;
    HotelFrag1 frag1 = new HotelFrag1();
    HotelFrag2 frag2 = new HotelFrag2();
    FragmentContainerView view1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int orientation = getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {

        } else {

        }

            mTitleArray = getResources().getStringArray(R.array.Titles);
            mQuoteArray = getResources().getStringArray(R.array.HotelLinks);
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("Hotels in Chicago");
            setContentView(R.layout.activity_hotel);

       // findViewById(R.id.webFrag).setVisibility(View.GONE);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.attract:
                System.out.println("HOTELS ----->>>> Attractions");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
