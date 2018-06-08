package com.bawei.myyikezhong.Xiangqing;

import com.bawei.myyikezhong.Tuijian.ui.base.BasePresenter;
import com.bawei.myyikezhong.Tuijian.ui.bean.XqBean;
import com.bawei.myyikezhong.Tuijian.ui.net.XqApi;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class Xiangqingpresenter  extends BasePresenter<XqContract.View> implements XqContract.Presenter{


    private XqApi xqApi;

    @Inject
    public Xiangqingpresenter(XqApi xqApi) {
        this.xqApi = xqApi;
    }

    @Override
    public void getXq(String wid) {

        xqApi.getXq(wid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<XqBean>() {
                    @Override
                    public void accept(XqBean xqBean) throws Exception {

                        mView.XqSuccess(xqBean);
                    }
                });
    }
}
