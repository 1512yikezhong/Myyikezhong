package com.bawei.myyikezhong.Tuijian.remen.m;

import android.util.Log;

import com.bawei.myyikezhong.Tuijian.remen.beans.Imgbean;
import com.bawei.myyikezhong.Tuijian.remen.beans.Videobean;
import com.bawei.myyikezhong.Tuijian.remen.net.Api;
import com.bawei.myyikezhong.Tuijian.remen.net.OkhttpUntils;
import com.bawei.myyikezhong.Tuijian.remen.net.OokhttpUntils;
import com.bawei.myyikezhong.Tuijian.remen.v.RementView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 王利博 on 2018/6/5.
 */

public class Mod implements  ModIm{
       private RementView rementView;

    public Mod(RementView rementView) {
        this.rementView = rementView;
    }

    @Override
    public void login() {
        OkhttpUntils.getmInstance().getRequestInterface(Api.URL_).getDame().enqueue(new Callback<Imgbean>() {
            @Override
            public void onResponse(Call<Imgbean> call, Response<Imgbean> response) {
                Imgbean body = response.body();
                if(body!=null){
                    rementView.getSuccess(body);
                }
            }

            @Override
            public void onFailure(Call<Imgbean> call, Throwable t) {
                Log.e("onFailure",t.getMessage());
            }
        });
    }

    @Override
    public void loginvideo(String page) {
        OokhttpUntils.getmInstance().getRequestInterface(Api.VIDEOURL_).getVideodata(page).enqueue(new Callback<Videobean>() {
            @Override
            public void onResponse(Call<Videobean> call, Response<Videobean> response) {
                Videobean body = response.body();
                rementView.getVideoSuccess(body);
            }

            @Override
            public void onFailure(Call<Videobean> call, Throwable t) {

            }
        });
    }
}
