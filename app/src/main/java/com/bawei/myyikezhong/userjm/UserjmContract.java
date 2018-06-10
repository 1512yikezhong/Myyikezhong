package com.bawei.myyikezhong.userjm;

import com.bawei.myyikezhong.Tuijian.ui.base.BaseContract;
import com.bawei.myyikezhong.Tuijian.ui.bean.UserjmBean;

public interface UserjmContract  {


    interface  View extends BaseContract.BaseView{

        void UserSuccess(UserjmBean data);

    }

    interface  Presenter extends BaseContract.BasePresenter<View>{

        void getUserjm(String uid,String token);

    }
}
