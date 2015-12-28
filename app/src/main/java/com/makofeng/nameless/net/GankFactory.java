package com.makofeng.nameless.net;

/**
 * Created by 冯浩 on 2015/12/10.
 */
public class GankFactory {

    protected static final Object o = new Object();
    public static GankApi sGankSingleton = null;

    public static final int meizhiSize = 100;

    public static GankApi getGankSingleton() {
        synchronized (o) {
            if (sGankSingleton == null) {
                sGankSingleton = new GankRetrofit().getGankService();
            }
            return sGankSingleton;
        }
    }

}
