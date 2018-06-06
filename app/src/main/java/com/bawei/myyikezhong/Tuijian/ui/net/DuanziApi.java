package com.bawei.myyikezhong.Tuijian.ui.net;


import com.bawei.myyikezhong.Tuijian.ui.bean.DuanziBean;

import io.reactivex.Observable;

public class DuanziApi {

    private static DuanziApi duanziApi;
    private DuanziApiService duanziApiService;

    private DuanziApi(DuanziApiService duanziApiService){

        this.duanziApiService=duanziApiService;

    }

    public  static  DuanziApi getDuanziApi(DuanziApiService duanziApiService){
        if (duanziApi ==null   ){
                duanziApi=new DuanziApi(duanziApiService);

        }
        return duanziApi;

     }


     public Observable<DuanziBean> getDuanzi(String page){

        return duanziApiService.getDuanzi(page);

     }


}
