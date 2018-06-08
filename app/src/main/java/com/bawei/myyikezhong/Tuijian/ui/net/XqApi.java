package com.bawei.myyikezhong.Tuijian.ui.net;

import com.bawei.myyikezhong.Tuijian.ui.bean.XqBean;

import io.reactivex.Observable;

public class XqApi {

    private static  XqApi xqApi;

    public XqApiService xqApiService;


    public  XqApi(XqApiService xqApiService){
        this.xqApiService=xqApiService;
    }

    public static XqApi getXqApi(XqApiService xqApiService) {

        if ( xqApi ==null){
            xqApi=new XqApi(xqApiService);
        }
        return xqApi;
    }

  public Observable<XqBean> getXq(String wid){

     return xqApiService.getXq(wid);
  }
}

