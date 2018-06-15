package com.bawei.myyikezhong.Tuijian.ui.net;

import com.bawei.myyikezhong.Tuijian.ui.bean.YesBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DainzanApiServoce {

    @GET("quarter/praise?appVersion=101&source=android")
    Observable<YesBean> getdianzan(@Query("uid") String uid,
                                  @Query("token") String token,
                                   @Query("wid") String wid);
}
