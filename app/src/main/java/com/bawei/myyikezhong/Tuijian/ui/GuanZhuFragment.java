package com.bawei.myyikezhong.Tuijian.ui;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bawei.myyikezhong.R;
import com.bawei.myyikezhong.Tuijian.ui.adapter.VideoAdapter;
import com.bawei.myyikezhong.Tuijian.ui.base.BaseFragment;
import com.bawei.myyikezhong.Tuijian.ui.bean.VideoBean;
import com.bawei.myyikezhong.Tuijian.ui.component.DaggerHttpComponent;
import com.bawei.myyikezhong.Tuijian.ui.guanzhu.contract.GuanzhuContract;
import com.bawei.myyikezhong.Tuijian.ui.guanzhu.presenter.Guanzhuprensenter;

import java.util.ArrayList;
import java.util.List;

public class GuanZhuFragment extends BaseFragment<Guanzhuprensenter> implements GuanzhuContract.View {

    private List<VideoBean.DataBean> data=new ArrayList<>();
    private VideoAdapter videoAdapter;


    @Override
    public int getContentLayout() {
        return R.layout.fragment_guanzhu;
    }

    @Override
    public void inject() {

        DaggerHttpComponent.builder()

                .build().inject(this);
    }

    @Override
    public void initView(View view) {

        RecyclerView rv = view.findViewById(R.id.rv);

        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.addItemDecoration(new DividerItemDecoration(getContext(),RecyclerView.VERTICAL));

        videoAdapter = new VideoAdapter(getContext(), data);
        rv.setAdapter(videoAdapter);
        //先求请求数据

        mPresenter.getVideo();
    }
    @Override
    public void videoSuccess(List<VideoBean.DataBean> data) {
        if (videoAdapter!=null){

            videoAdapter.setData(data);
        }
    }

}
