package com.makofeng.nameless.mvp.presenter;

import com.makofeng.nameless.model.Gank;
import com.makofeng.nameless.model.GankData;
import com.makofeng.nameless.mvp.views.GankView;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 冯浩 on 2015/12/22.
 */
public class GankPresenter extends MvpRxPresenter<GankView> {


    public void initData(int year,int month,int day) {

        Observable<GankData> gankDataObservable = mGank.getGankData(year, month, day);

        Subscription s = gankDataObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GankData>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().showError(e);
                    }

                    @Override
                    public void onNext(GankData gankData) {
                        getView().showContent(addAllResults(gankData.results));
                    }
                });
        getCompositeSubscription().add(s);

    }

    private List<Gank> addAllResults(GankData.Result results) {
        List<Gank> mGankList=new ArrayList<>();
        if (results.androidList != null) mGankList.addAll(results.androidList);
        if (results.iOSList != null) mGankList.addAll(results.iOSList);
        if (results.appList != null) mGankList.addAll(results.appList);
        if (results.拓展资源List != null) mGankList.addAll(results.拓展资源List);
        if (results.瞎推荐List != null) mGankList.addAll(results.瞎推荐List);
        if (results.休息视频List != null) mGankList.addAll(0, results.休息视频List);
        return mGankList;
    }

}
