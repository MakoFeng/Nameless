package com.makofeng.nameless.net;

import com.makofeng.nameless.model.GankData;
import com.makofeng.nameless.model.MeizhiData;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by 冯浩 on 2015/12/10.
 */
public interface GankApi {

    @GET("data/福利/" + GankFactory.meizhiSize + "/{page}")
    Observable<MeizhiData> getMeizhiData(
            @Path("page") int page);

    @GET("day/{year}/{month}/{day}")
    Observable<GankData> getGankData(
            @Path("year") int year,
            @Path("month") int month,
            @Path("day") int day);




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
