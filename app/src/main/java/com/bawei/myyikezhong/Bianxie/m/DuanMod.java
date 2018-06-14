package com.bawei.myyikezhong.Bianxie.m;

import com.bawei.myyikezhong.Bianxie.bean.Duanzibean;
import com.bawei.myyikezhong.Bianxie.v.DuanView;
import com.bawei.myyikezhong.Tuijian.remen.net.Api;
import com.bawei.myyikezhong.Tuijian.remen.net.OkhttpUntils;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 王利博 on 2018/6/13.
 */

public class DuanMod implements  DuanModIm{
    private DuanView duanView;

    public DuanMod(DuanView duanView) {
        this.duanView = duanView;
    }

    @Override
    public void login(Map<String, String> map) {
        OkhttpUntils.getmInstance().getRequestInterface(Api.URL_).getduanzi(map).enqueue(new Callback<Duanzibean>() {
            @Override
            public void onResponse(Call<Duanzibean> call, Response<Duanzibean> response) {
                Duanzibean body = response.body();
                duanView.getSuccess(body);
            }

            @Override
            public void onFailure(Call<Duanzibean> call, Throwable t) {

            }
        });
    }
}
