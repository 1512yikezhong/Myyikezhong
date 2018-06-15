package com.bawei.myyikezhong.Tuijian.ui.net;

import com.bawei.myyikezhong.Tuijian.ui.bean.YesBean;

import io.reactivex.Observable;

public class DianzanApi {

    private static  DianzanApi dianzanApi;

    private DainzanApiServoce dainzanApiServoce;

    public DianzanApi(DainzanApiServoce dainzanApiServoce) {
        this.dainzanApiServoce = dainzanApiServoce;
    }

    public static DianzanApi getDianzanApi(DainzanApiServoce dainzanApiServoce) {
        if (dianzanApi==null){
          dianzanApi=  new DianzanApi(dainzanApiServoce);
        }
        return dianzanApi;
    }

    public Observable<YesBean> getdianzan(String uid,String token, String wid){

        return dainzanApiServoce.getdianzan(uid, token, wid);
    }
}
