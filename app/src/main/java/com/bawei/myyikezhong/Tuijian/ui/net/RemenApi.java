package com.bawei.myyikezhong.Tuijian.ui.net;

import com.bawei.myyikezhong.Tuijian.ui.bean.HotBean;

import io.reactivex.Observable;

public class RemenApi {

    private static  RemenApi remenApi;

    private RemenAoiService remenAoiService;


    public  RemenApi(RemenAoiService remenAoiService){
        this.remenAoiService=remenAoiService;

    }

    public static RemenApi getRemenApi(RemenAoiService remenAoiService) {

        if (remenApi==null){
            remenApi=new RemenApi(remenAoiService);
        }
        return remenApi;
    }

    public Observable<HotBean> getRemenVideo(String page){

        return remenAoiService.gethotremen(page);

    }
}
