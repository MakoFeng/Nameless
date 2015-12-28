package com.makofeng.nameless.mvp.presenter;

import com.makofeng.nameless.model.MeizhiData;
import com.makofeng.nameless.mvp.views.MeizhiView;
import com.makofeng.nameless.utils.L;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 冯浩 on 2015/12/22.
 */
public class MeizhiPresenter extends MvpRxPresenter<MeizhiView> {


    int mPage = 1;


    public void initData(boolean pullToRefresh) {


        if (pullToRefresh)
            getView().showLoading();

        mPage = 1;

        requestData(mPage, false);

    }

    public void loadForMore() {
        mPage += 1;
        requestData(mPage, true);
    }

    private void requestData(int page, final boolean isLoadForMore) {
        Observable<MeizhiData> meizhiDataObservable = mGank.getMeizhiData(page);

        Subscription s = meizhiDataObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MeizhiData>() {
                    @Override
                    public void onCompleted() {
                        L.i("MeizhiPresenter", "onCompleted()");
                        getView().hideLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        L.i("MeizhiPresenter", "onError()" + e.getMessage());
                        getView().showError(e);
                        getView().hideLoading();
                    }

                    @Override
                    public void onNext(MeizhiData meizhiData) {

                        L.i("MeizhiPresenter", "onNext()");

                        if (meizhiData == null || meizhiData.results.size() == 0) {

                            if (!isLoadForMore)
                                getView().showEmpty();

                        } else {


                            if (isLoadForMore) {
                                getView().loadMoreData(meizhiData);
                            } else {
                                getView().showContent(meizhiData);
                            }


                            if (meizhiData.results.size() < 100) {
                                getView().showFootView(false);
                            } else {
                                getView().showFootView(true);
                            }

                        }

                    }
                });

        getCompositeSubscription().add(s);
    }


}
