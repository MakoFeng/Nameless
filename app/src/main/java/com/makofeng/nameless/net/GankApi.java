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

}
