package com.makofeng.nameless.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.makofeng.nameless.R;
import com.makofeng.nameless.model.Gank;
import com.makofeng.nameless.mvp.presenter.GankPresenter;
import com.makofeng.nameless.mvp.views.GankView;
import com.makofeng.nameless.ui.adapter.GankListAdapter;
import com.makofeng.nameless.utils.L;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 冯浩 on 2016/2/18.
 */
public class GankActivity extends MvpActivity<GankView, GankPresenter> implements GankView {

    private int year;
    private int month;
    private int day;
    private String title;
    private String url;

    @Bind(R.id.backdrop)
    ImageView backdrop;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @Bind(R.id.rv_gank)
    RecyclerView rvGank;

    private GankListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gank);
        ButterKnife.bind(this);
        Intent intent = getIntent();

        title = intent.getStringExtra("title");

        url = intent.getStringExtra("url");

        year = intent.getIntExtra("year", 0);
        month = intent.getIntExtra("month", 0);
        day = intent.getIntExtra("day", 0);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        collapsingToolbar.setTitle(title);

        initView();

        presenter.initData(year, month, day);

    }

    private void initView() {
        Picasso.with(this).load(url).fit().centerCrop().into(backdrop);
        rvGank.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GankListAdapter(this);
        rvGank.setAdapter(adapter);
    }

    @NonNull
    @Override
    public GankPresenter createPresenter() {
        return new GankPresenter();
    }

    @Override
    public void showContent(List<Gank> data) {

        L.i("GankActivity", "size======" + data.size());
        adapter.setData(data);
    }

    @Override
    public void showError(Throwable e) {
        L.i("GankActivity", "Throwable======" + e.getMessage());
    }

    @Override
    public void showEmpty() {

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
