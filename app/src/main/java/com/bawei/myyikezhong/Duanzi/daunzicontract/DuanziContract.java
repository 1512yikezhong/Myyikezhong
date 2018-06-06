package com.bawei.myyikezhong.Duanzi.daunzicontract;


import com.bawei.myyikezhong.Tuijian.ui.base.BaseContract;
import com.bawei.myyikezhong.Tuijian.ui.bean.DuanziBean;

import java.util.List;


public interface DuanziContract {
    interface  View extends BaseContract.BaseView{


        void onSuccess(List<DuanziBean.DataBean> dataBeans);

    }
    interface  Presnter extends BaseContract.BasePresenter<View>{
        void getDuanzi(String page);
    }

}
