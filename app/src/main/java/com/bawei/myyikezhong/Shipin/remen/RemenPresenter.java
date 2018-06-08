package com.bawei.myyikezhong.Shipin.remen;

import com.bawei.myyikezhong.Tuijian.ui.base.BasePresenter;
import com.bawei.myyikezhong.Tuijian.ui.bean.HotBean;
import com.bawei.myyikezhong.Tuijian.ui.net.RemenApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RemenPresenter extends BasePresenter<RemenContract.View> implements RemenContract.Presenter {

    private RemenApi remenApi;

    @Inject
    public  RemenPresenter(RemenApi remenApi){
        this.remenApi=remenApi;

    }


    @Override
    public void getHotVideo(String page) {


        remenApi.getRemenVideo(page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Function<HotBean, List<HotBean.DataBean>>() {
                    @Override
                    public List<HotBean.DataBean> apply(HotBean hotBean) throws Exception {
                        return hotBean.getData();
                    }
                }).subscribe(new Consumer<List<HotBean.DataBean>>() {
            @Override
            public void accept(List<HotBean.DataBean> dataBeans) throws Exception {

                if (mView!=null){

                    mView.hotSuccess(dataBeans);

                }
            }
        });
    }
}
