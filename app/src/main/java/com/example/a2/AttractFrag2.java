package com.example.a2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class AttractFrag2 extends Fragment {
    private Integer index;
    WebView mWebView;
    static String[] mQuoteArray;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setRetainInstance(true);
        mQuoteArray = getResources().getStringArray(R.array.AttractLinks);
        View v = inflater.inflate(R.layout.web, container, false);
        mWebView = (WebView) v.findViewById(R.id.webPage);
        mWebView.getSettings().setJavaScriptEnabled(true);
        return v;
    }
    public void showWebView(int index) {
        if (index >= mQuoteArray.length) {
            return;
        }
        this.index = index;
        mWebView.loadUrl(mQuoteArray[index]);
    }
    @Override
    public void onViewCreated (@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        if (index != null) {
            showWebView(index);
        }
    }
    @Override
    public void onPause() {
        super.onPause();
        //save.putCharSequence("url",null);
    }
}

