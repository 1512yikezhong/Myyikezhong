package com.bawei.myyikezhong.Tuijian.ui.net;

import com.bawei.myyikezhong.Tuijian.ui.bean.VideoBean;

import io.reactivex.Observable;

public class GuanzhuApi {

     private static  GuanzhuApi guanzhuApi;
     private GuanzhuApiService guanzhuApiService;


     public GuanzhuApi(GuanzhuApiService guanzhuApiService){
         this.guanzhuApiService=guanzhuApiService;

     }

        public static GuanzhuApi getGuanzhuApi(GuanzhuApiService guanzhuApiService) {

         if (guanzhuApi==null){

             guanzhuApi=new GuanzhuApi(guanzhuApiService);

         }
            return guanzhuApi;
        }

        public Observable<VideoBean> getVideo(){

         return guanzhuApiService.getVideo();

        }

    }
