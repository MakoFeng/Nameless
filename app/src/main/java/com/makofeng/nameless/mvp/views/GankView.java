package com.makofeng.nameless.mvp.views;

import com.makofeng.nameless.model.Gank;

import java.util.List;

/**
 * Created by 冯浩 on 2015/12/22.
 */
public interface GankView extends MvpView{

    /**
     * 显示内容
     */
    void showContent(List<Gank> data);

    /**
     * 显示错误
     */
    void showError(Throwable e);

    /**
     * 显示内容空的情况
     */
    void showEmpty();


}
