package com.bawei.myyikezhong.SanRegLogin.xiugai.m;

import com.bawei.myyikezhong.SanRegLogin.denluzhuce.bean.Studentbean;
import com.bawei.myyikezhong.SanRegLogin.xiugai.bean.Xiugaibean;
import com.bawei.myyikezhong.SanRegLogin.xiugai.v.XiugaiView;
import com.bawei.myyikezhong.Tuijian.remen.net.Api;
import com.bawei.myyikezhong.Tuijian.remen.net.OokhttpUntils;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 王利博 on 2018/6/8.
 */

public class XiugaiMod implements XiuModIm {
    private XiugaiView xiugaiView;

    public XiugaiMod(XiugaiView xiugaiView) {
        this.xiugaiView = xiugaiView;
    }

    @Override
    public void login(Map<String, String> map) {
        OokhttpUntils.getmInstance().getRequestInterface(Api.URL_).xiugaipass(map).enqueue(new Callback<Xiugaibean>() {
            @Override
            public void onResponse(Call<Xiugaibean> call, Response<Xiugaibean> response) {
                Xiugaibean body = response.body();
                xiugaiView.getSuccess(body);
            }

            @Override
            public void onFailure(Call<Xiugaibean> call, Throwable t) {

            }
        });
    }
}
