package com.bawei.myyikezhong.Tuijian.ui.net;

import com.bawei.myyikezhong.Tuijian.ui.bean.SuijiBean;

import io.reactivex.Observable;

public class SuijiApi {

    private static  SuijiApi suijiApi;
    private  SuijiApiService suijiApiService;

    public SuijiApi(SuijiApiService suijiApiService) {
        this.suijiApiService = suijiApiService;
    }

    public static SuijiApi getSuijiApi(SuijiApiService suijiApiService) {
        if (suijiApi==null){
         suijiApi=   new SuijiApi(suijiApiService);
        }
        return suijiApi;
    }

    public Observable<SuijiBean> getsuiji(){
        return  suijiApiService.getsousuo();
    }
}
