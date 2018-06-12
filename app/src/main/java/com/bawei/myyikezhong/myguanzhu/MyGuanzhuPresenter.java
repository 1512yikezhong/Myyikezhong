package com.bawei.myyikezhong.myguanzhu;

import com.bawei.myyikezhong.Tuijian.ui.base.BasePresenter;
import com.bawei.myyikezhong.Tuijian.ui.bean.MyGuanzhuBean;
import com.bawei.myyikezhong.Tuijian.ui.net.MuGuanzhuApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MyGuanzhuPresenter extends BasePresenter<MyGuanzhuContract.View> implements MyGuanzhuContract.Presenter{

    private MuGuanzhuApi muGuanzhuApi;

    @Inject
    public MyGuanzhuPresenter(MuGuanzhuApi muGuanzhuApi) {
        this.muGuanzhuApi = muGuanzhuApi;
    }

    @Override
    public void getMyGuanzhu() {

        muGuanzhuApi.getguanzhu()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Function<MyGuanzhuBean, List<MyGuanzhuBean.DataBean>>() {
                    @Override
                    public List<MyGuanzhuBean.DataBean> apply(MyGuanzhuBean myGuanzhuBean) throws Exception {
                        return myGuanzhuBean.getData();
                    }
                }).subscribe(new Consumer<List<MyGuanzhuBean.DataBean>>() {
            @Override
            public void accept(List<MyGuanzhuBean.DataBean> dataBeans) throws Exception {
                      mView.myGunzhu(dataBeans);
            }
        })     ;


    }
}
