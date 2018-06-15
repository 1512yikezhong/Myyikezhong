package com.bawei.myyikezhong.Tuijian.ui.guanzhu.contract;

import com.bawei.myyikezhong.Tuijian.ui.base.BaseContract;
import com.bawei.myyikezhong.Tuijian.ui.bean.VideoBean;
import com.bawei.myyikezhong.Tuijian.ui.bean.YesBean;

import java.util.List;

public interface GuanzhuContract {

    interface  View extends BaseContract.BaseView{

        void videoSuccess(List<VideoBean.DataBean> data);

        void dianzan(YesBean data);


    }


    interface  Presenter extends BaseContract.BasePresenter<View>{

        void getVideo();

        void dianzan(String uid,String token,String wid);


    }
}
