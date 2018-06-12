package com.bawei.myyikezhong.myguanzhu;

import com.bawei.myyikezhong.Tuijian.ui.base.BaseContract;
import com.bawei.myyikezhong.Tuijian.ui.bean.MyGuanzhuBean;

import java.util.List;

public interface MyGuanzhuContract {

    interface  View extends BaseContract.BaseView{

        void myGunzhu(List<MyGuanzhuBean.DataBean> data);

    }

    interface  Presenter extends BaseContract.BasePresenter<View>{

        void getMyGuanzhu();

    }
}
