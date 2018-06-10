package com.bawei.myyikezhong.Tuijian.ui.net;

import com.bawei.myyikezhong.Tuijian.ui.bean.FujinBean;

import io.reactivex.Observable;

public class FujinApi {
    private  static FujinApi fujinApi;
    private FujinApiService fujinApiService;

    public FujinApi(FujinApiService fujinApiService){
        this.fujinApiService=fujinApiService;

    }

    public static FujinApi getFujinApi(FujinApiService fujinApiService) {
        if (fujinApi==null){
          fujinApi=  new FujinApi(fujinApiService);
        }
        return fujinApi;
    }

    public Observable<FujinBean> getfujin(String page){
        return  fujinApiService.getfujin(page);
    }
}
