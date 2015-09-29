package com.example.prakhar1001.viewpager1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.example.prakhar1001.viewpager1.com.example.prakhar1001.viewpager1.Adaptor.FullScreenImageAdapter;
import com.example.prakhar1001.viewpager1.com.example.prakhar1001.viewpager1.helper.Utils;

/**
 * Created by Prakhar1001 on 9/26/2015.
 */

public class FullScreenViewActivity extends Activity {

    private Utils utils;
    private FullScreenImageAdapter adapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen_view);

        viewPager = (ViewPager) findViewById(R.id.pager);

        utils = new Utils(getApplicationContext());

        Intent i = getIntent();
        int position = i.getIntExtra("position", 0);

        adapter = new FullScreenImageAdapter(FullScreenViewActivity.this,
                utils.getFilePaths());

        viewPager.setAdapter(adapter);

        // displaying selected image first
        viewPager.setCurrentItem(position);
    }
}
