package com.bawei.myyikezhong.Tuijian.ui.net;


import com.bawei.myyikezhong.Tuijian.ui.bean.DuanziBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface DuanziApiService {

    @FormUrlEncoded
    @POST("quarter/getJokes")
    Observable<DuanziBean> getDuanzi(@Field("page") String page);

}
