package com.bawei.myyikezhong.Tuijian.ui.net;

import com.bawei.myyikezhong.Tuijian.ui.bean.HotBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RemenAoiService {


    @FormUrlEncoded
    @POST("quarter/getHotVideos?token=C9E316BA0DBF0A4926320921E70C112D")
    Observable<HotBean> gethotremen(@Field("page") String page);
}
