package com.bawei.myyikezhong.Tuijian.ui.net;

import com.bawei.myyikezhong.Tuijian.ui.bean.SousuoBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SousuoApiService {

    @GET("quarter/searchFriends?source=android&appVersion=101")
    Observable<SousuoBean> getsousuo(@Query("keywords") String keywords,
                                     @Query("page") String page);
}
