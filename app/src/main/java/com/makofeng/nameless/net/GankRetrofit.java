package com.makofeng.nameless.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by 冯浩 on 2015/12/10.
 */
public class GankRetrofit {

    public static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

    final GankApi gankService;

    public GankRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gank.avosapps.com/api/")
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        gankService = retrofit.create(GankApi.class);

    }

    public GankApi getGankService() {
        return gankService;
    }

}
