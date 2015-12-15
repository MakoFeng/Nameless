package com.makofeng.nameless.mvp.presenter;

import com.makofeng.nameless.mvp.views.MvpView;

/**
 * Created by 冯浩 on 2015/12/15.
 */
public interface MvpPresenter<V extends MvpView> {

    /**
     * 绑定View到Presenter
     */
    void attachView(V view);

    /**
     * 解绑View
     */
    void detachView();
}