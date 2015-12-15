package com.makofeng.nameless.mvp.delegate;


import com.makofeng.nameless.mvp.presenter.MvpPresenter;
import com.makofeng.nameless.mvp.views.MvpView;

/**
 * Created by 冯浩 on 2015/7/21.
 */
public class MvpInternalDelegate<V extends MvpView, P extends MvpPresenter<V>> {

    protected MvpDelegateCallback<V, P> delegateCallback;

    MvpInternalDelegate(MvpDelegateCallback<V, P> delegateCallback) {

        if (delegateCallback == null) {
            throw new NullPointerException("MvpDelegateCallback is null!");
        }

        this.delegateCallback = delegateCallback;
    }

    /**
     * Called  to create the presenter (if no other one already exisits)
     */
    void createPresenter() {

        P presenter = delegateCallback.getPresenter();
        if (presenter == null) {
            presenter = delegateCallback.createPresenter();
        }
        if (presenter == null) {
            throw new NullPointerException("Presenter is null! Do you return null in createPresenter()?");
        }

        delegateCallback.setPresenter(presenter);
    }

    /**
     * Attaches the view to the presenter
     */
    void attachView() {
        getPresenter().attachView(delegateCallback.getMvpView());
    }

    /**
     * Called to detach the view from presenter
     */
    void detachView() {
        getPresenter().detachView();
    }

    private P getPresenter() {
        P presenter = delegateCallback.getPresenter();
        if (presenter == null) {
            throw new NullPointerException("Presenter returned from getPresenter() is null");
        }
        return presenter;
    }
}