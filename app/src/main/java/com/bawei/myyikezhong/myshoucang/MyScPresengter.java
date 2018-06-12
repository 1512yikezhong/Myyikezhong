package com.bawei.myyikezhong.myshoucang;

import com.bawei.myyikezhong.Tuijian.ui.base.BasePresenter;
import com.bawei.myyikezhong.Tuijian.ui.bean.MyshoucangBean;
import com.bawei.myyikezhong.Tuijian.ui.net.MyScApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MyScPresengter extends BasePresenter<MyScContract.View> implements MyScContract.Presenter{

    private MyScApi myScApi;

    @Inject
    public MyScPresengter(MyScApi myScApi) {
        this.myScApi = myScApi;
    }

    @Override
    public void myShoucang(String uid, String token) {

        myScApi.getshoucang(uid, token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Function<MyshoucangBean, List<MyshoucangBean.DataBean>>() {
                    @Override
                    public List<MyshoucangBean.DataBean> apply(MyshoucangBean myshoucangBean) throws Exception {
                        return myshoucangBean.getData();
                    }
                }).subscribe(new Consumer<List<MyshoucangBean.DataBean>>() {
            @Override
            public void accept(List<MyshoucangBean.DataBean> dataBeans) throws Exception {
                mView.myShoucang(dataBeans);
            }
        });
    }
}
