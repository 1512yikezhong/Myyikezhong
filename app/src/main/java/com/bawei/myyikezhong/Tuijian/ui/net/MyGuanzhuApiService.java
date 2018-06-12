package com.bawei.myyikezhong.Tuijian.ui.net;

import com.bawei.myyikezhong.Tuijian.ui.bean.MyGuanzhuBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyGuanzhuApiService {

    @GET("quarter/getFollowUsers?uid=11068&token=C55773B10ABD8BFB6739BD5C16D6F803&appVersion=101&source=android")
    Observable<MyGuanzhuBean> getmmyguanzhu();

}
