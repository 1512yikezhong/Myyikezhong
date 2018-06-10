package com.bawei.myyikezhong.Qutu.m;

import com.bawei.myyikezhong.Qutu.bean.Qutubean;
import com.bawei.myyikezhong.Qutu.v.QuView;
import com.bawei.myyikezhong.Tuijian.remen.net.Api;
import com.bawei.myyikezhong.Tuijian.remen.net.OkhttpUntils;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 王利博 on 2018/6/10.
 */

public class QuMod implements  QuModIm{
    private QuView quView;

    public QuMod(QuView quView) {
        this.quView = quView;
    }

    @Override
    public void login(Map<String, String> map) {
        OkhttpUntils.getmInstance().getRequestInterface(Api.URL_).getqutu(map).enqueue(new Callback<Qutubean>() {
            @Override
            public void onResponse(Call<Qutubean> call, Response<Qutubean> response) {
                Qutubean body = response.body();
                quView.getSuccess(body);
            }

            @Override
            public void onFailure(Call<Qutubean> call, Throwable t) {

            }
        });
    }
}
