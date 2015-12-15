package com.makofeng.nameless.mvp.delegate;


import com.makofeng.nameless.mvp.presenter.MvpPresenter;
import com.makofeng.nameless.mvp.views.MvpView;

/**
 * Created by 冯浩 on 2015/7/21.
 */
public interface MvpDelegateCallback<V extends MvpView, P extends MvpPresenter<V>> {

    /**
     * 创建 Presenter
     */
    public P createPresenter();

    /**
     * 返回MVP Presenter
     */
    public P getPresenter();

    /**
     * 设置 Presenter
     */
    public void setPresenter(P presenter);

    /**
     * 返回MVP 中的View
     */
    public V getMvpView();


}
