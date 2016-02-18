package com.makofeng.nameless.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.makofeng.nameless.R;
import com.makofeng.nameless.model.MeizhiData;
import com.makofeng.nameless.mvp.presenter.MeizhiPresenter;
import com.makofeng.nameless.mvp.views.MeizhiView;
import com.makofeng.nameless.ui.adapter.MeizhiAdapter;
import com.makofeng.nameless.widget.MultiStateView;
import com.makofeng.nameless.widget.RecyclerView.HeaderAndFooterRecyclerViewAdapter;
import com.makofeng.nameless.widget.RecyclerView.RecyclerFooterView;
import com.makofeng.nameless.widget.RecyclerView.RecyclerOnScrollListener;
import com.makofeng.nameless.widget.RecyclerView.RecyclerViewUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends MvpActivity<MeizhiView, MeizhiPresenter> implements MeizhiView, SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = "MainActivity";


    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.rv_meizhi)
    RecyclerView rvMeizhi;
    @Bind(R.id.mv_state)
    MultiStateView mvState;
    @Bind(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;

    private MeizhiAdapter adapter;
    private HeaderAndFooterRecyclerViewAdapter mHeaderAndFooterRecyclerViewAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        initView();
        presenter.initData(true);
    }

    private void initView() {
        swipeRefresh.setOnRefreshListener(this);
        rvMeizhi.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MeizhiAdapter(this);
        mHeaderAndFooterRecyclerViewAdapter = new HeaderAndFooterRecyclerViewAdapter(adapter);
        rvMeizhi.setAdapter(mHeaderAndFooterRecyclerViewAdapter);
        showFootView(true);
        rvMeizhi.addOnScrollListener(mOnScrollListener);
    }

    private RecyclerOnScrollListener mOnScrollListener = new RecyclerOnScrollListener() {

        @Override
        public void onLoadNextPage(View view) {
            super.onLoadNextPage(view);
            presenter.loadForMore();
        }
    };

    @NonNull
    @Override
    public MeizhiPresenter createPresenter() {
        return new MeizhiPresenter();
    }

    @Override
    public void showLoading() {
        mvState.setViewState(MultiStateView.VIEW_STATE_LOADING);
    }

    @Override
    public void hideLoading() {
        swipeRefresh.setRefreshing(false);
    }

    @Override
    public void showContent(MeizhiData data) {
        adapter.setData(data.results);
        mvState.setViewState(MultiStateView.VIEW_STATE_CONTENT);
    }

    @Override
    public void showError(Throwable e) {
        mvState.setViewState(MultiStateView.VIEW_STATE_ERROR);
    }

    @Override
    public void showEmpty() {
        mvState.setViewState(MultiStateView.VIEW_STATE_EMPTY);
    }

    @Override
    public void showFootView(boolean b) {

        if (b){
            RecyclerViewUtils.setFooterView(rvMeizhi, new RecyclerFooterView(this));
        }else {
            RecyclerViewUtils.removeFooterView(rvMeizhi);
        }


    }

    @Override
    public void loadMoreData(MeizhiData data) {
        adapter.addItems(data.results);
    }

    @Override
    public void onRefresh() {
        presenter.initData(false);
        showFootView(true);
    }
}
