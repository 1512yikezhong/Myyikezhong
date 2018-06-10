package com.bawei.myyikezhong.Tuijian.ui.net;

import com.bawei.myyikezhong.Tuijian.ui.bean.FujinBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FujinApiService {

    @GET("quarter/getNearVideos?token=C9E316BA0DBF0A4926320921E70C112D&source=android&appVersion=101")
    Observable<FujinBean> getfujin(@Query("psage") String page);
}
