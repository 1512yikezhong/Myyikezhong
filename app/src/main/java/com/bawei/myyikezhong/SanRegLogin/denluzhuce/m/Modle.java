package com.bawei.myyikezhong.SanRegLogin.denluzhuce.m;

import com.bawei.myyikezhong.SanRegLogin.denluzhuce.Iview;
import com.bawei.myyikezhong.SanRegLogin.denluzhuce.bean.Studentbean;
import com.bawei.myyikezhong.SanRegLogin.denluzhuce.p.Perer;
import com.bawei.myyikezhong.Tuijian.remen.net.Api;
import com.bawei.myyikezhong.Tuijian.remen.net.OokhttpUntils;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 王利博 on 2018/6/7.
 */

public class Modle implements ModIim {
    private Iview iview;

    public Modle(Iview iview) {
        this.iview = iview;
    }

    @Override
    public void login( Map<String,String> map) {

        OokhttpUntils.getmInstance().getRequestInterface(Api.URL_).getlogin(map).enqueue(new Callback<Studentbean>() {
            @Override
            public void onResponse(Call<Studentbean> call, Response<Studentbean> response) {
                Studentbean body = response.body();
                iview.getSuccess(body);
            }

            @Override
            public void onFailure(Call<Studentbean> call, Throwable t) {

            }
        });
    }
}
