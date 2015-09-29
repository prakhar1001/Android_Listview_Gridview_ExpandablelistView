package com.example.prakhar1001.viewpager1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.prakhar1001.viewpager1.com.example.prakhar1001.viewpager1.Adaptor.GridAdapter;
import com.example.prakhar1001.viewpager1.com.example.prakhar1001.viewpager1.helper.AppConstant;
import com.example.prakhar1001.viewpager1.com.example.prakhar1001.viewpager1.helper.Utils;

import java.util.ArrayList;

public class SecondFragment extends Fragment {


    private Utils utils;

    private int columnWidth;
    private ArrayList<String> imagePaths = new ArrayList<String>();
    private GridAdapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView;
        rootView = inflater.inflate(R.layout.activity_second_fragment, container, false);
        GridView gridView= (GridView) rootView.findViewById(R.id.gridview);
        utils = new Utils(getActivity());
        columnWidth = (int) ((utils.getScreenWidth() - ((AppConstant.NUM_OF_COLUMNS + 1) )) / AppConstant.NUM_OF_COLUMNS);
        // loading all image paths from SD card
        imagePaths = utils.getFilePaths();
        // Gridview adapter
        adapter = new GridAdapter(getActivity(), imagePaths, columnWidth);
        // setting grid view adapter
        gridView.setAdapter(adapter);
        return rootView;
    }

    }

