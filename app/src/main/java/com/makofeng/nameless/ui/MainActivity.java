package com.makofeng.nameless.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.makofeng.nameless.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);


//        Observable<MeizhiData> meizhiDataObservable = mGank.getMeizhiData(1);
//
//        Subscription s = meizhiDataObservable
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<MeizhiData>() {
//                    @Override
//                    public void onCompleted() {
//
//                        L.i(TAG, "onCompleted");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        L.i(TAG, "onError" + e);
//                    }
//
//                    @Override
//                    public void onNext(MeizhiData meizhiData) {
//                        L.i(TAG, "onNext" + meizhiData.results.get(0).url);
//
//                    }
//                });
//
//        addSubscription(s);


//        Observable<GankData> gankDataObservable = mGank.getGankData(2015, 12, 10);
//
//        Subscription s = gankDataObservable
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<GankData>() {
//                    @Override
//                    public void onCompleted() {
//                        L.i(TAG, "onCompleted");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        L.i(TAG, "onError" + e);
//                    }
//
//                    @Override
//                    public void onNext(GankData gankData) {
//                        L.i(TAG, "onNext" + gankData.results.androidList.get(0).url);
//                    }
//                });
//        addSubscription(s);





    }
}
