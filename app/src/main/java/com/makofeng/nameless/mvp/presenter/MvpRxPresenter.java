package com.makofeng.nameless.mvp.presenter;

import android.support.annotation.Nullable;

import com.makofeng.nameless.mvp.views.MvpView;
import com.makofeng.nameless.net.GankApi;
import com.makofeng.nameless.net.GankFactory;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by 冯浩 on 2015/12/24.
 */
public class MvpRxPresenter<V extends MvpView> implements MvpPresenter<V> {


    public static final GankApi mGank = GankFactory.getGankSingleton();

    private CompositeSubscription mCompositeSubscription;

    private V view;

    @Override
    public void attachView(V view) {
        this.view = view;
        mCompositeSubscription = new CompositeSubscription();
    }

    public CompositeSubscription getCompositeSubscription() {
        return mCompositeSubscription;
    }

    @Nullable
    public V getView() {
        return view;
    }

    @Override
    public void detachView() {
        if (this.mCompositeSubscription != null) {
            this.mCompositeSubscription.unsubscribe();
        }
    }
}
