package com.bawei.myyikezhong.Tuijian.ui.net;

import com.bawei.myyikezhong.Tuijian.ui.bean.UserjmBean;

import io.reactivex.Observable;

public class UserjmApi {
    private static  UserjmApi userjmApi;

    private UserjmApiService userjmApiService;

    public UserjmApi(UserjmApiService userjmApiService) {
        this.userjmApiService = userjmApiService;
    }

    public static UserjmApi getUserjmApi(UserjmApiService userjmApiService) {
        if (userjmApi==null){
          userjmApi=  new UserjmApi(userjmApiService);
        }
        return userjmApi;
    }

    public Observable<UserjmBean> getuserjm(String uid,String token){

        return userjmApiService.getuserjm(uid,token);
    }
}
