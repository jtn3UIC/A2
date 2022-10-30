package com.example.a2;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class AttractActivity  extends AppCompatActivity {
    public static String hurl = null;
    static String[] mTitleArray;

    FragmentManager fragmentManager;
    // @SuppressLint("StaticFieldLeak")
    AttractFrag1 frag1;
    AttractFrag2 frag2;
    FragmentContainerView view1;
    FrameLayout view2;
    static int Parent = LinearLayout.LayoutParams.MATCH_PARENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //frag1.act = this;
        setContentView(R.layout.activity_attract);
        mTitleArray = getResources().getStringArray(R.array.Attract);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Attractions in Chicago");
        view1 =  (FragmentContainerView) findViewById(R.id.titles);
        view2 = (FrameLayout) findViewById(R.id.webFrag);
        fragmentManager = getSupportFragmentManager();//FragmentManager();
        frag1 = (AttractFrag1) fragmentManager.findFragmentByTag("AttractFrag1");
        frag2 = (AttractFrag2) fragmentManager.findFragmentByTag("AttractFrag2");
        FragmentTransaction mTransaction = fragmentManager.beginTransaction();
        if (frag1 == null) {
            frag1 = new AttractFrag1();
        }
        if (frag2 == null) {
            frag2 = new AttractFrag2();
        } else {
            if (!frag2.isAdded()) {
                mTransaction.replace(R.id.webFrag, frag2, "AttractFrag2").addToBackStack(null).commit();
            }
        }
        mTransaction.replace(R.id.titles, frag1,"AttractFrag1").commit();
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
            fragmentTransaction.replace(R.id.webFrag, frag2,"AttractFrag2").addToBackStack(null).commit();
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
        switch (item.getItemId()) {
            case R.id.attract:
                Intent myIntent = new Intent(this, HotelActivity.class);
                startActivity(myIntent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
