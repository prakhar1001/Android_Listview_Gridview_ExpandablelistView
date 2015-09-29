package com.example.prakhar1001.viewpager1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ThirdFragment extends Fragment {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_third_fragment, container, false);

        // get the listview
        expListView = (ExpandableListView) rootView.findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        return rootView;
    }
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("#optimusinfo");
        listDataHeader.add(" #optimusmobility");
        listDataHeader.add("#optimusqa");
        listDataHeader.add("#optimusbi");

        // Adding child data
        List<String> optimusinfo= new ArrayList<String>();


        List<String> optimusmobility = new ArrayList<String>();


        List<String> optimusqa = new ArrayList<String>();

        List<String> optimusbi = new ArrayList<String>();
        optimusbi.add("2 Guns");

        listDataChild.put(listDataHeader.get(0), optimusinfo); // Header, Child data
        listDataChild.put(listDataHeader.get(1), optimusmobility);
        listDataChild.put(listDataHeader.get(2), optimusqa);
        listDataChild.put(listDataHeader.get(3), optimusbi);
    }

}