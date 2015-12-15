package com.makofeng.nameless.mvp.delegate;

import android.os.Bundle;

import com.makofeng.nameless.mvp.presenter.MvpPresenter;
import com.makofeng.nameless.mvp.views.MvpView;

/**
 * Created by 冯浩 on 2015/7/21.
 */
public class ActivityMvpDelegateImpl<V extends MvpView, P extends MvpPresenter<V>>
        implements ActivityMvpDelegate {

    protected MvpInternalDelegate<V, P> internalDelegate;
    protected MvpDelegateCallback<V, P> delegateCallback;


    public ActivityMvpDelegateImpl(MvpDelegateCallback<V, P> delegateCallback) {
        if (delegateCallback == null){
            throw new NullPointerException("MvpDelegateCallback is null!");
        }
        this.delegateCallback = delegateCallback;
    }

    protected MvpInternalDelegate<V, P> getInternalDelegate() {
        if (internalDelegate == null) {
            internalDelegate = new MvpInternalDelegate<>(delegateCallback);
        }

        return internalDelegate;
    }

    @Override
    public void onCreate(Bundle bundle) {
        getInternalDelegate().createPresenter();
        getInternalDelegate().attachView();
    }

    @Override
    public void onDestroy() {
        getInternalDelegate().detachView();
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onRestart() {

    }
}
