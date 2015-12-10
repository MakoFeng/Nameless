package com.makofeng.nameless.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.makofeng.nameless.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by 冯浩 on 2015/12/8.
 */
public class AppStart extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_start);

        Observable.timer(2, TimeUnit.SECONDS, AndroidSchedulers.mainThread()).subscribe(new Subscriber<Long>() {
            @Override
            public void onCompleted() {
                Intent intent = new Intent(AppStart.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Long aLong) {

            }
        });

    }
}
