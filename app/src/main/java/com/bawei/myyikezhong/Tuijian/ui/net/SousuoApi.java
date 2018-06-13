package com.bawei.myyikezhong.Tuijian.ui.net;

import com.bawei.myyikezhong.Tuijian.ui.bean.SousuoBean;

import io.reactivex.Observable;

public class SousuoApi {

    private static  SousuoApi sousuoApi;

    private SousuoApiService sousuoApiService;

    public SousuoApi(SousuoApiService sousuoApiService) {
        this.sousuoApiService = sousuoApiService;
    }

    public static SousuoApi getSousuoApi(SousuoApiService sousuoApiService) {

        if (sousuoApi==null){
           sousuoApi= new SousuoApi(sousuoApiService);

        }
        return sousuoApi;
    }

    public Observable<SousuoBean> getsousuo(String page, String keywords){

        return sousuoApiService.getsousuo(keywords,page);

    }
}
