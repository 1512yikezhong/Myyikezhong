package com.bawei.myyikezhong.Xiangqing;

import com.bawei.myyikezhong.Tuijian.ui.base.BaseContract;
import com.bawei.myyikezhong.Tuijian.ui.bean.XqBean;

public interface XqContract {

    interface  View extends BaseContract.BaseView{

        void XqSuccess(XqBean data);

    }

    interface  Presenter extends BaseContract.BasePresenter<View>{

        void getXq(String wid);

    }
}
