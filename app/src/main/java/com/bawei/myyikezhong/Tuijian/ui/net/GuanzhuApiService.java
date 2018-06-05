package com.bawei.myyikezhong.Tuijian.ui.net;

import com.bawei.myyikezhong.Tuijian.ui.bean.VideoBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface GuanzhuApiService {

    @GET("satinApi?type=4&page=1")
    Observable<VideoBean> getVideo();
}
