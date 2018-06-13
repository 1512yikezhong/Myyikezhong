package com.bawei.myyikezhong.Tuijian.ui.net;

import com.bawei.myyikezhong.Tuijian.ui.bean.SuijiBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface SuijiApiService {

    @GET("quarter/randomFriends?source=android&appVersion=101")
    Observable<SuijiBean> getsousuo();
}
