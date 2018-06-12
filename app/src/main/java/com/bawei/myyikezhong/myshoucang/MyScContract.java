package com.bawei.myyikezhong.myshoucang;

import com.bawei.myyikezhong.Tuijian.ui.base.BaseContract;
import com.bawei.myyikezhong.Tuijian.ui.bean.MyshoucangBean;

import java.util.List;

public interface MyScContract {

    interface  View extends BaseContract.BaseView{

        void myShoucang(List<MyshoucangBean.DataBean> data);

    }

    interface  Presenter extends BaseContract.BasePresenter<View>{
        void myShoucang(String uid, String token);
    }
}
