package com.bawei.myyikezhong.SanRegLogin.reg.m;

import com.bawei.myyikezhong.SanRegLogin.bean.Userbean;
import com.bawei.myyikezhong.SanRegLogin.reg.LoginView;
import com.bawei.myyikezhong.Tuijian.remen.net.Api;
import com.bawei.myyikezhong.Tuijian.remen.net.OkhttpUntils;
import com.bawei.myyikezhong.Tuijian.remen.net.OokhttpUntils;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 王利博 on 2018/6/7.
 */

public class Mod implements Moim {
    private LoginView loginView;

    public Mod(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void login(Map<String, String> map) {
        OokhttpUntils.getmInstance().getRequestInterface(Api.URL_).getDDD(map).enqueue(new Callback<Userbean>() {
            @Override
            public void onResponse(Call<Userbean> call, Response<Userbean> response) {

                Userbean body = response.body();
                loginView.getSuccess(body);
            }

            @Override
            public void onFailure(Call<Userbean> call, Throwable t) {

            }
        });
    }
}
