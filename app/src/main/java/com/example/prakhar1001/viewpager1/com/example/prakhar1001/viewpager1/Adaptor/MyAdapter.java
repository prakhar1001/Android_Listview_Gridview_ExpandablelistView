package com.example.prakhar1001.viewpager1.com.example.prakhar1001.viewpager1.Adaptor;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.prakhar1001.viewpager1.R;
import com.example.prakhar1001.viewpager1.Single_Row;

import java.util.ArrayList;

/**
 * Created by Prakhar1001 on 9/23/2015.
 */
public class MyAdapter extends BaseAdapter  {

    private Context con;
    public ArrayList<Single_Row> Packet;
    ViewHolder vh;


    public MyAdapter(Context c){
        con=c;
    }

    public MyAdapter(Context c, ArrayList<Single_Row> arr){
        Packet=arr;
        con=c;
    }

    public int getCount() {
        return Packet.size();
    }

    public Single_Row getItem(int i) {
        return Packet.get(i);
    }

    public int getItemViewType(int position) {
        return position;
    }

    public int getViewTypeCount() {
        return getCount();
    }

    public long getItemId(int arg0) {
        return 0;
    }
    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        ViewHolder vh = null;

        if (view == null) {
            LayoutInflater mInflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.list_items, null);
            vh = new ViewHolder();
            vh.caption = (EditText) view.findViewById(R.id.edit_text);
            vh.checkcaption = (CheckBox) view.findViewById(R.id.check_box);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }


        vh.caption.setText(getItem(i).getText());
        vh.checkcaption.setChecked(getItem(i).isCheck());

        //Listener on edit text if gets changed ,A watcher has been assigned to it which enables output according to the state of the transition being made
        vh.caption.addTextChangedListener(new TextWatcher() {

            //
            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                getItem(i).setText(arg0.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
            }
        });

        vh.checkcaption.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
                getItem(i).setCheck(arg1);
            }
        });
        return view;
    }




    public static class ViewHolder {
        EditText caption;
        CheckBox checkcaption;

    }
}
