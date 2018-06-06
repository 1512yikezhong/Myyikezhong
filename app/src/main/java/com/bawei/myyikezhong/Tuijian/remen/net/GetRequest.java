package com.bawei.myyikezhong.Tuijian.remen.net;

import com.bawei.myyikezhong.Tuijian.remen.beans.Imgbean;
import com.bawei.myyikezhong.Tuijian.remen.beans.Videobean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 王利博 on 2018/6/5.
 */

public interface GetRequest {
    //轮播
    @GET("quarter/getAd")
    Call<Imgbean> getDame();
    //视频
    @GET("satinApi")
    Call<Videobean> getVideodata(@Query("page") String page);
}