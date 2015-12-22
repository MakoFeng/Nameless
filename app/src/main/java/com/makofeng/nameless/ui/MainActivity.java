package com.makofeng.nameless.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.makofeng.nameless.R;
import com.makofeng.nameless.model.MeizhiData;
import com.makofeng.nameless.mvp.presenter.MeizhiPresenter;
import com.makofeng.nameless.mvp.views.MeizhiView;
import com.makofeng.nameless.ui.adapter.MeizhiAdapter;
import com.makofeng.nameless.widget.MultiStateView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        initView();
        presenter.initData(false);

//        Observable<GankData> gankDataObservable = mGank.getGankData(2015, 12, 10);
//
//        Subscription s = gankDataObservable
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<GankData>() {
//                    @Override
//                    public void onCompleted() {
//                        L.i(TAG, "onCompleted");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        L.i(TAG, "onError" + e);
//                    }
//
//                    @Override
//                    public void onNext(GankData gankData) {
//                        L.i(TAG, "onNext" + gankData.results.androidList.get(0).url);
//                    }
//                });
//        addSubscription(s);


    }

    private void initView() {
        swipeRefresh.setOnRefreshListener(this);
        rvMeizhi.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MeizhiAdapter(this);
        rvMeizhi.setAdapter(adapter);
    }

    @NonNull
    @Override
    public MeizhiPresenter createPresenter() {
        return new MeizhiPresenter();
    }

    @Override
    public void showLoading() {
        swipeRefresh.setRefreshing(true);
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

    }

    @Override
    public void loadMoreData(MeizhiData data) {

    }

    @Override
    public void onRefresh() {
        presenter.initData(true);
    }
}
