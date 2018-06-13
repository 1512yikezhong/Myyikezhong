package com.bawei.myyikezhong.sousuo;

import com.bawei.myyikezhong.Tuijian.ui.base.BaseContract;
import com.bawei.myyikezhong.Tuijian.ui.bean.SousuoBean;
import com.bawei.myyikezhong.Tuijian.ui.bean.SuijiBean;

import java.util.List;

public interface SousuoContract {


    interface  View extends BaseContract.BaseView{

        void sousuo(List<SousuoBean.DataBean> data);

        void suiji(List<SuijiBean.DataBean> data);

    }

    interface  Presenter extends BaseContract.BasePresenter<View>{
        void mysousuo(String keywords, String page);

        void suiji();
    }
}
