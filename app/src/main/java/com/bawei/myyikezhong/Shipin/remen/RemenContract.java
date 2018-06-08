package com.bawei.myyikezhong.Shipin.remen;

import com.bawei.myyikezhong.Tuijian.ui.base.BaseContract;
import com.bawei.myyikezhong.Tuijian.ui.bean.HotBean;

import java.util.List;

public interface RemenContract {

    interface  View extends BaseContract.BaseView{

       void  hotSuccess(List<HotBean.DataBean> data);

    }


    interface  Presenter extends BaseContract.BasePresenter<RemenContract.View>{

        void getHotVideo(String page);

    }

//    interface  View extends BaseContract.BaseView{
//
//        void onSuccess(List<DuanziBean.DataBean> dataBeans);
//
//    }
//    interface  Presnter extends BaseContract.BasePresenter<DuanziContract.View>{
//        void getDuanzi(String page);
//    }

}
