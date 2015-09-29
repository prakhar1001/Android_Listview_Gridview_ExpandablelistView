package com.example.prakhar1001.viewpager1.com.example.prakhar1001.viewpager1.Adaptor;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.prakhar1001.viewpager1.FullScreenViewActivity;
import com.example.prakhar1001.viewpager1.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {

  //  private Context con;
    private Activity _activity;
    private ArrayList<String> _filePaths = new ArrayList<String>();
    private int imageWidth;

    public GridAdapter(Activity activity, ArrayList<String> filePaths,
                       int imageWidth) {
        this._activity = activity;
        this._filePaths = filePaths;
        this.imageWidth = imageWidth;
    }

   /* public GridAdapter(Context c) {
        con = c;
    }*/

    @Override
    public int getCount() {
        return this._filePaths.size();
    }

    @Override
    public Object getItem(int position) {
        return this._filePaths.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater mInflater = (LayoutInflater) _activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewHolderImage vhi;


        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.grid_items, null);
            vhi = new ViewHolderImage();
            vhi.imageView = (ImageView) convertView.findViewById(R.id.imageview);
            convertView.setTag(vhi);
        }
        else
        {
            vhi = (ViewHolderImage) convertView.getTag();
        }

        // get screen dimensions
        Bitmap image = decodeFile(_filePaths.get(position), imageWidth,
                imageWidth);

        vhi.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        vhi.imageView.setLayoutParams(new LinearLayout.LayoutParams(imageWidth,
                imageWidth));
        vhi.imageView.setImageBitmap(image);

        // image view click listener
        vhi.imageView.setOnClickListener(new OnImageClickListener(position));


        return convertView;


    }

    class OnImageClickListener implements OnClickListener {

        int _postion;

        // constructor
        public OnImageClickListener(int position) {
            this._postion = position;
        }

        @Override
        public void onClick(View v) {
            // on selecting grid view image
            // launch full screen activity
            Intent i = new Intent(_activity, FullScreenViewActivity.class);
            i.putExtra("position", _postion);
            _activity.startActivity(i);
        }

    }

    /*
     * Resizing image size
     */
    public static Bitmap decodeFile(String filePath, int WIDTH, int HIGHT) {
        try {

            File f = new File(filePath);

            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(new FileInputStream(f), null, o);

            final int REQUIRED_WIDTH = WIDTH;
            final int REQUIRED_HIGHT = HIGHT;
            int scale = 1;
            while (o.outWidth / scale / 2 >= REQUIRED_WIDTH
                    && o.outHeight / scale / 2 >= REQUIRED_HIGHT)
                scale *= 2;

            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static class ViewHolderImage {
       ImageView imageView;

    }
}
