package com.makofeng.nameless.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.makofeng.nameless.R;
import com.makofeng.nameless.ui.adapter.ImageGalleryAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 冯浩 on 2015/12/29.
 */
public class ImageGalleryActivity extends BaseActivity {


    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.vp_image)
    ViewPager vpImage;

    private List<String> images;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_gallery);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);


        Intent intent = getIntent();

        images = intent.getStringArrayListExtra("images");
        title = intent.getStringExtra("title");

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(title);
        }

        initView();
    }

    private void initView() {
        ImageGalleryAdapter adapter = new ImageGalleryAdapter(images,this);
        vpImage.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

}
