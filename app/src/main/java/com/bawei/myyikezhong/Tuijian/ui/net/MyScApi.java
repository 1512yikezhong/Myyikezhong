package com.bawei.myyikezhong.Tuijian.ui.net;

import com.bawei.myyikezhong.Tuijian.ui.bean.MyshoucangBean;

import io.reactivex.Observable;

public class MyScApi {

    private static  MyScApi myScApi;

    private MyScApiService myScApiService;


    public MyScApi(MyScApiService MyScApiService){
        this.myScApiService=MyScApiService;

    }

    public static MyScApi getMyScApi(MyScApiService myScApiService) {

        if (myScApi==null){
           myScApi= new MyScApi(myScApiService);
        }
        return myScApi;
    }

    public Observable<MyshoucangBean> getshoucang(String uid,String token){

        return  myScApiService.getshoucang(uid, token);
    }


}
