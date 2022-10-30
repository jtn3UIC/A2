package com.example.a2;

import android.annotation.SuppressLint;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import  androidx.fragment.*;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class HotelActivity extends AppCompatActivity {
    public static String hurl = null;
    static String[] mTitleArray;

    FragmentManager fragmentManager;
   // @SuppressLint("StaticFieldLeak")
    HotelFrag1 frag1;// = new HotelFrag1();

    HotelFrag2 frag2;// = new HotelFrag2();
    FragmentContainerView view1;
    FrameLayout view2;
    static int Parent = LinearLayout.LayoutParams.MATCH_PARENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //frag1.act = this;
        setContentView(R.layout.activity_hotel);
        mTitleArray = getResources().getStringArray(R.array.Titles);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Hotels in Chicago");
        view1 =  (FragmentContainerView) findViewById(R.id.titles);
        view2 = (FrameLayout) findViewById(R.id.webFrag);
        fragmentManager = getSupportFragmentManager();//FragmentManager();
        frag1 = (HotelFrag1) fragmentManager.findFragmentByTag("HotelFrag1");
        frag2 = (HotelFrag2) fragmentManager.findFragmentByTag("HotelFrag2");
        FragmentTransaction mTransaction = fragmentManager.beginTransaction();
        if (frag1 == null) {
            frag1 = new HotelFrag1();
        }
        if (frag2 == null) {
            frag2 = new HotelFrag2();
        } else {
            if (!frag2.isAdded()) {
                mTransaction.replace(R.id.webFrag, frag2, "HotelFrag2").addToBackStack(null).commit();
            }
        }
        mTransaction.replace(R.id.titles, frag1,"HotelFrag1").commit();
        fragmentManager.executePendingTransactions();

        changeLayout();
        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            public void onBackStackChanged() {
                changeLayout();
            }
        });
    }
    void changeLayout() {
        int orient = getResources().getConfiguration().orientation;
        if(orient== Configuration.ORIENTATION_PORTRAIT){
            if (!frag2.isAdded()) {
                view1.setLayoutParams(new LinearLayout.LayoutParams(Parent, Parent));
                view2.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
            } else {
                view1.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
                view2.setLayoutParams(new LinearLayout.LayoutParams(Parent, Parent));
            }
        } else {
            if (!frag2.isAdded()) {
                view1.setLayoutParams(new LinearLayout.LayoutParams(Parent, Parent));
                view2.setLayoutParams(new LinearLayout.LayoutParams(0,0));
            } else {
                view1.setLayoutParams(new LinearLayout.LayoutParams(0,Parent, 1));
                view2.setLayoutParams(new LinearLayout.LayoutParams(0,Parent, 2));
            }
        }
    }
    public void select(int index) {
        if (!frag2.isAdded()) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.webFrag, frag2,"HotelFrag2").addToBackStack(null).commit();
            fragmentManager.executePendingTransactions();
        }
        frag2.showWebView(index);
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
