package com.bawei.myyikezhong.sousuo;

import com.bawei.myyikezhong.Tuijian.ui.base.BasePresenter;
import com.bawei.myyikezhong.Tuijian.ui.bean.SousuoBean;
import com.bawei.myyikezhong.Tuijian.ui.bean.SuijiBean;
import com.bawei.myyikezhong.Tuijian.ui.net.SousuoApi;
import com.bawei.myyikezhong.Tuijian.ui.net.SuijiApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class SousuoPresenter extends BasePresenter<SousuoContract.View> implements SousuoContract.Presenter {


    private SousuoApi sousuoApi;

    private SuijiApi suijiApi;

    @Inject
    public SousuoPresenter(SousuoApi sousuoApi,SuijiApi suijiApi) {
        this.sousuoApi = sousuoApi;
        this.suijiApi=suijiApi;

    }

    @Override
    public void mysousuo(String keywords, String page) {

        sousuoApi.getsousuo(page,keywords)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Function<SousuoBean, List<SousuoBean.DataBean>>() {
                    @Override
                    public List<SousuoBean.DataBean> apply(SousuoBean sousuoBean) throws Exception {
                        return sousuoBean.getData();
                    }
                }).subscribe(new Consumer<List<SousuoBean.DataBean>>() {
            @Override
            public void accept(List<SousuoBean.DataBean> dataBeans) throws Exception {
                if (mView!=null){
                    mView.sousuo(dataBeans);
                }

            }
        });


    }

    @Override
    public void suiji() {

        suijiApi.getsuiji()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Function<SuijiBean, List<SuijiBean.DataBean>>() {
                    @Override
                    public List<SuijiBean.DataBean> apply(SuijiBean suijiBean) throws Exception {
                        return suijiBean.getData();
                    }
                }).subscribe(new Consumer<List<SuijiBean.DataBean>>() {
            @Override
            public void accept(List<SuijiBean.DataBean> dataBeans) throws Exception {
                if (mView!=null){
                    mView.suiji(dataBeans);
                }

            }
        });

    }


}
