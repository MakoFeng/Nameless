package com.makofeng.nameless.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 冯浩 on 2015/12/10.
 */
public class GankData {

    public Result results;
    public List<String> category;

    public class Result {
        @SerializedName("Android") public List<Meizhi> androidList;
        @SerializedName("休息视频") public List<Meizhi> 休息视频List;
        @SerializedName("iOS") public List<Meizhi> iOSList;
        @SerializedName("福利") public List<Meizhi> 妹纸List;
        @SerializedName("拓展资源") public List<Meizhi> 拓展资源List;
        @SerializedName("瞎推荐") public List<Meizhi> 瞎推荐List;
        @SerializedName("App") public List<Meizhi> appList;
    }

}
