package com.bawei.myyikezhong.Tuijian.ui.net;

import com.bawei.myyikezhong.Tuijian.ui.bean.MyshoucangBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyScApiService {

    @GET("quarter/getFavorites?source=android&appVersion=101")
    Observable<MyshoucangBean> getshoucang(@Query("uid") String uid, @Query("token") String token);
}
