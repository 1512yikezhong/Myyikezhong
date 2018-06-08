package com.bawei.myyikezhong.Tuijian.remen.net;

import com.bawei.myyikezhong.SanRegLogin.bean.Userbean;
import com.bawei.myyikezhong.SanRegLogin.denluzhuce.bean.Studentbean;
import com.bawei.myyikezhong.SanRegLogin.xiugai.bean.Xiugaibean;
import com.bawei.myyikezhong.Tuijian.remen.beans.Imgbean;
import com.bawei.myyikezhong.Tuijian.remen.beans.Videobean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by 王利博 on 2018/6/5.
 */

public interface GetRequest {
    //轮播
    @GET("quarter/getAd")
    Call<Imgbean> getDame();
    //视频
    @GET("satinApi")
    Call<Videobean> getVideodata(@Query("page") String page);
        //注册
    //quarter/register
    @POST("quarter/register")
    @FormUrlEncoded
     Call<Userbean> getDDD(@FieldMap Map<String,String> map);
    //登录
    //https://www.zhaoapi.cn/user/login?mobile=15195014384&password=123456
    @POST("user/login")
    @FormUrlEncoded
    Call<Studentbean> getlogin(@FieldMap Map<String,String> map);

    //修改密码
    //quarter/getPass?mobile=15195014384&newPass=654321
    @POST("quarter/getPass")
    @FormUrlEncoded
    Call<Xiugaibean> xiugaipass(@FieldMap Map<String,String> map);

}