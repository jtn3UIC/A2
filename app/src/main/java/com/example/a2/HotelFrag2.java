package com.example.a2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class HotelFrag2 extends Fragment {
    private String url;
    WebView mWebView;
    public HotelFrag2(String url) {
        this.url = url;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Log.i(TAG, getClass().getSimpleName() + ":entered onCreateView()");
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.web, container, false);
        mWebView = (WebView) v.findViewById(R.id.webPage);
        //url = "10.1.1.8/dona1clickmobile/index.php";

        mWebView.getSettings().setJavaScriptEnabled(true);
        //mWebView.setWebViewClient(new SwAWebClient());
        mWebView.loadUrl(url);

        return v;
    }
    @Override
    public void onViewCreated (@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);


    }
}
