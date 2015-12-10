package com.makofeng.nameless.ui;

import android.support.v7.app.AppCompatActivity;

import com.makofeng.nameless.net.GankApi;
import com.makofeng.nameless.net.GankFactory;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by 冯浩 on 2015/12/8.
 */
public class BaseActivity extends AppCompatActivity {

    public static final GankApi mGank = GankFactory.getGankSingleton();

    private CompositeSubscription mCompositeSubscription;


    public CompositeSubscription getCompositeSubscription() {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new CompositeSubscription();
        }

        return this.mCompositeSubscription;
    }


    public void addSubscription(Subscription s) {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new CompositeSubscription();
        }

        this.mCompositeSubscription.add(s);
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        if (this.mCompositeSubscription != null) {
            this.mCompositeSubscription.unsubscribe();
        }
    }


}
