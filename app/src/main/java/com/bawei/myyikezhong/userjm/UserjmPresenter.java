package com.bawei.myyikezhong.userjm;

import com.bawei.myyikezhong.Tuijian.ui.base.BasePresenter;
import com.bawei.myyikezhong.Tuijian.ui.bean.UserjmBean;
import com.bawei.myyikezhong.Tuijian.ui.net.UserjmApi;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class UserjmPresenter extends BasePresenter<UserjmContract.View>implements UserjmContract.Presenter{

    private UserjmApi userjmApi;

    @Inject
    public UserjmPresenter(UserjmApi userjmApi) {
        this.userjmApi = userjmApi;
    }



    @Override
    public void getUserjm(String uid, String token) {

        userjmApi.getuserjm(uid,token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
               .map(new Function<UserjmBean, UserjmBean>() {
                   @Override
                   public UserjmBean apply(UserjmBean userjmBean) throws Exception {
                       return userjmBean;
                   }
               }).subscribe(new Consumer<UserjmBean>() {
            @Override
            public void accept(UserjmBean userjmBean) throws Exception {
                mView.UserSuccess(userjmBean);
            }
        });
    }
}
