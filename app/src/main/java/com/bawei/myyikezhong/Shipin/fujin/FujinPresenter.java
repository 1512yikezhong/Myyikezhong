package com.bawei.myyikezhong.Shipin.fujin;

import com.bawei.myyikezhong.Tuijian.ui.base.BasePresenter;
import com.bawei.myyikezhong.Tuijian.ui.bean.FujinBean;
import com.bawei.myyikezhong.Tuijian.ui.net.FujinApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class FujinPresenter extends BasePresenter<FujinContract.View> implements FujinContract.Presenter{

    private FujinApi fujinApi;

    @Inject
    public FujinPresenter(FujinApi fujinApi) {
        this.fujinApi = fujinApi;
    }

    @Override
    public void getfujin(String page) {

        fujinApi.getfujin(page)

                .observeOn(AndroidSchedulers.mainThread())

                .subscribeOn(Schedulers.io())

                .map(new Function<FujinBean, List<FujinBean.DataBean>>() {

                    @Override
                    public List<FujinBean.DataBean> apply(FujinBean fujinBean) throws Exception {

                        return fujinBean.getData();

                    }
                }).subscribe(new Consumer<List<FujinBean.DataBean>>() {

            @Override
            public void accept(List<FujinBean.DataBean> dataBeans) throws Exception {

                mView.fjSuccess(dataBeans);

            }
        });

    }
}
