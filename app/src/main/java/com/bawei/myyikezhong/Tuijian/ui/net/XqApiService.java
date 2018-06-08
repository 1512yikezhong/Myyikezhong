package com.bawei.myyikezhong.Tuijian.ui.net;

import com.bawei.myyikezhong.Tuijian.ui.bean.XqBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface XqApiService {


//    @FormUrlEncoded
//    @POST("quarter/getVideoDetail")
//    Observable<XiangqingBean> getxq(@Field("wid") String wid);


    @GET("quarter/getVideoDetail")
    Observable<XqBean> getXq(@Query("wid") String wid);
}
