package com.makofeng.nameless.mvp.delegate;

import android.os.Bundle;

import com.makofeng.nameless.mvp.presenter.MvpPresenter;
import com.makofeng.nameless.mvp.views.MvpView;


/**
 * Created by 冯浩 on 2015/7/21.
 */
public interface ActivityMvpDelegate<V extends MvpView, P extends MvpPresenter<V>> {


    void onCreate(Bundle bundle);


    void onDestroy();


    void onPause();


    void onResume();


    void onStart();


    void onStop();


    void onRestart();

}
