package com.makofeng.nameless.mvp.presenter;

import com.makofeng.nameless.model.MeizhiData;
import com.makofeng.nameless.mvp.views.MeizhiView;
import com.makofeng.nameless.net.GankApi;
import com.makofeng.nameless.net.GankFactory;
import com.makofeng.nameless.utils.L;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by 冯浩 on 2015/12/22.
 */
public class MeizhiPresenter implements MvpPresenter<MeizhiView> {


    private static final GankApi mGank = GankFactory.getGankSingleton();

    private CompositeSubscription mCompositeSubscription;

    private MeizhiView meizhiView;

    @Override
    public void attachView(MeizhiView view) {
        this.meizhiView = view;
    }

    public void initData(boolean pullToRefresh) {

        if (pullToRefresh){
            meizhiView.showLoading();
        }

        Observable<MeizhiData> meizhiDataObservable = mGank.getMeizhiData(1);

        Subscription s = meizhiDataObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MeizhiData>() {
                    @Override
                    public void onCompleted() {

                        L.i("MeizhiPresenter","onCompleted()");
                        meizhiView.hideLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        L.i("MeizhiPresenter","onError()"+e.getMessage());
                        meizhiView.showError(e);
                        meizhiView.hideLoading();
                    }

                    @Override
                    public void onNext(MeizhiData meizhiData) {

                        L.i("MeizhiPresenter","onNext()");

                        if (meizhiData==null||meizhiData.results.size()==0){
                            meizhiView.showEmpty();
                        }else {
                            meizhiView.showContent(meizhiData);
                        }

                    }
                });

        mCompositeSubscription = new CompositeSubscription();

        mCompositeSubscription.add(s);
    }


    @Override
    public void detachView() {
        if (this.mCompositeSubscription != null) {
            this.mCompositeSubscription.unsubscribe();
        }
    }

}
