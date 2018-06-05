package com.bawei.myyikezhong.Tuijian.ui.guanzhu.presenter;

import com.bawei.myyikezhong.Tuijian.ui.base.BasePresenter;
import com.bawei.myyikezhong.Tuijian.ui.bean.VideoBean;
import com.bawei.myyikezhong.Tuijian.ui.guanzhu.contract.GuanzhuContract;
import com.bawei.myyikezhong.Tuijian.ui.net.GuanzhuApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class Guanzhuprensenter  extends BasePresenter<GuanzhuContract.View>implements GuanzhuContract.Presenter{

    private GuanzhuApi guanzhuApi;

    @Inject
    public Guanzhuprensenter(GuanzhuApi guanzhuApi){
        this.guanzhuApi=guanzhuApi;
    }

    @Override
    public void getVideo() {

        guanzhuApi.getVideo()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Function<VideoBean, List<VideoBean.DataBean>>() {
                    @Override
                    public List<VideoBean.DataBean> apply(VideoBean videoBean) throws Exception {
                        return videoBean.getData();
                    }
                }).subscribe(new Consumer<List<VideoBean.DataBean>>() {
            @Override
            public void accept(List<VideoBean.DataBean> dataBeans) throws Exception {

                if (mView!=null){
                    mView.videoSuccess(dataBeans);
                }
            }
        });

    }

}
