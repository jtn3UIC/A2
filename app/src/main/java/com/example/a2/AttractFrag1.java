package com.example.a2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.ViewModelProvider;

public class AttractFrag1  extends ListFragment {
    private static final String TAG = "AttractFrag1";
    private ListViewModel mModel;
    private String[] links;
    public AttractActivity act;
    @Override
    public void onListItemClick(ListView l, View v, int pos, long id) {

        // Indicates the selected item has been checked
        getListView().setItemChecked(pos, true);
        mModel.selectItem(pos);
        act = (AttractActivity) getActivity();
        act.select(pos);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, getClass().getSimpleName() + ":entered onCreateView()");
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    @Override
    public void onViewCreated (@NonNull View view, Bundle savedInstanceState){

        Log.i(TAG, getClass().getSimpleName() + ":entered onViewCreated()");
        super.onViewCreated(view, savedInstanceState);

        // Note: requireActivity() is similar to getActivity() but cannot return null
        mModel = new ViewModelProvider(requireActivity()).get(ListViewModel.class);

        // Set the list choice mode to allow only one selection at a time
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        // Set the list adapter for the ListView
        // Discussed in more detail in the user interface classes lesson
        setListAdapter(new ArrayAdapter<String>(getActivity(),
                R.layout.hotel_item, AttractActivity.mTitleArray));
        links = getResources().getStringArray(R.array.AttractLinks);

    }
}
