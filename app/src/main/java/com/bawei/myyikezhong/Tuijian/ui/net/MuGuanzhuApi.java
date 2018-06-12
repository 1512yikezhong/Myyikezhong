
package com.bawei.myyikezhong.Tuijian.ui.net;

import com.bawei.myyikezhong.Tuijian.ui.bean.MyGuanzhuBean;

import io.reactivex.Observable;

public class MuGuanzhuApi {

    private static  MuGuanzhuApi muGuanzhuApi;

    private MyGuanzhuApiService myGuanzhuApiService;

    public  MuGuanzhuApi(MyGuanzhuApiService myGuanzhuApiService){
        this.myGuanzhuApiService=myGuanzhuApiService;

    }

    public static MuGuanzhuApi getMuGuanzhuApi(MyGuanzhuApiService myGuanzhuApiService) {

        if (muGuanzhuApi==null){
             muGuanzhuApi = new MuGuanzhuApi(myGuanzhuApiService);
        }
        return muGuanzhuApi;
    }

    public Observable<MyGuanzhuBean> getguanzhu(){

        return myGuanzhuApiService.getmmyguanzhu();

    }
}
