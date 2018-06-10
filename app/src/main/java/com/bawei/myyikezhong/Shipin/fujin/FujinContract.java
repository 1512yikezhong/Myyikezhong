package com.bawei.myyikezhong.Shipin.fujin;

import com.bawei.myyikezhong.Tuijian.ui.base.BaseContract;
import com.bawei.myyikezhong.Tuijian.ui.bean.FujinBean;

import java.util.List;

public interface FujinContract {


    interface  View extends BaseContract.BaseView{

        void fjSuccess(List<FujinBean.DataBean> data);

    }

    interface  Presenter extends BaseContract.BasePresenter<FujinContract.View>{

        void getfujin(String page);

    }
}
