package com.bawei.myyikezhong.Tuijian.ui.net;

import com.bawei.myyikezhong.Tuijian.ui.bean.UserjmBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserjmApiService {


    @GET("user/getUserInfo")
    Observable<UserjmBean>getuserjm(@Query("uid") String uid,
                                    @Query("token") String token);


}
