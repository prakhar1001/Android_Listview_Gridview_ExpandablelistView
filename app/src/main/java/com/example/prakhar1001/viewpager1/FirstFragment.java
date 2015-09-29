package com.example.prakhar1001.viewpager1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.prakhar1001.viewpager1.com.example.prakhar1001.viewpager1.Adaptor.MyAdapter;

import java.util.ArrayList;

public class FirstFragment extends Fragment {


    private ArrayList<Single_Row> list;
    private MyAdapter adapter;
    private ListView lv;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_first_fragment, container, false);
        lv = (ListView) view.findViewById(R.id.listView);
        return view;
    }

    /*
     *	Saving the State of Listview for achieving persistance
     */
    public void onSaveInstanceState(Bundle outState) {

        outState.putParcelableArrayList("Array_list", list);
        super.onSaveInstanceState(outState);
    }

    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            list = savedInstanceState.getParcelableArrayList("Array_list");
        }
        if (list == null) {
            list = new ArrayList<Single_Row>();
            for (int i = 0; i < 100; i++) {
                list.add(new Single_Row("", false));
            }
        }
        adapter = new MyAdapter(getActivity(), list);
        lv.setAdapter(adapter);
    }
}





