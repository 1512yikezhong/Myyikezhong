package com.bawei.myyikezhong.Duanzi;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.bawei.myyikezhong.Duanzi.daunzicontract.DuanziContract;
import com.bawei.myyikezhong.Duanzi.duanziadapter.DuanziAdapter;
import com.bawei.myyikezhong.R;
import com.bawei.myyikezhong.Tuijian.ui.base.BaseFragment;
import com.bawei.myyikezhong.Tuijian.ui.bean.DuanziBean;
import com.bawei.myyikezhong.Tuijian.ui.component.DaggerHttpComponent;
import com.bawei.myyikezhong.userjm.UserActivity;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by 王利博 on 2018/6/5.
 */


public class DuanziFragment extends BaseFragment<DuanziPresenter>implements  DuanziContract.View {


    private XRecyclerView xlv;
    private List<DuanziBean.DataBean> list = new ArrayList<>();

    private boolean isRefresh = true;
    private int page = 1;

    private DuanziAdapter duanziAdapter;


    @Override
    public int getContentLayout() {
        return R.layout.layout_duanzi;
    }

    @Override
    public void inject() {

        DaggerHttpComponent.builder()
                .build().inject(this);
    }

    @Override
    public void initView(View view) {
        xlv = view.findViewById(R.id.xrl);
        xlv.setLayoutManager(new LinearLayoutManager(getContext()));

        duanziAdapter = new DuanziAdapter(getContext(), list);
        xlv.setAdapter(duanziAdapter);
        mPresenter.getDuanzi(page+"");

        //设置刷新和加载和更多

        xlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override   ///
            public void onRefresh() {
                //刷新
                page=1;
                isRefresh=true;
                mPresenter.getDuanzi(page+"");

            }

            @Override
            public void onLoadMore() {
                //加载更多
                page++;
                isRefresh=false;
                mPresenter.getDuanzi(page+"");

            }
        });


        duanziAdapter.setlistener(new DuanziAdapter.Listener() {
            @Override
            public void onClick(View view, int position) {

                //startActivity(new Intent(getContext(), UserActivity.class));


                Intent intent=new Intent(getContext(), UserActivity.class);
                intent.putExtra("uid",list.get(position).getUid());
              //  intent.putExtra("token",list.get(position))
                startActivity(intent);
            }

            @Override
            public void longClick(View view, int position) {

            }
        });

    }

    @Override
    public void onSuccess(List<DuanziBean.DataBean> list) {


        //刷新和加载更多

        if (isRefresh){
            duanziAdapter.refresh(list);
            //关闭刷新
            xlv.refreshComplete();
        } else {

            duanziAdapter.loadMore(list);
            //结束加载更多

            int listNum = duanziAdapter.getListNum();
            xlv.refreshComplete();
            int size=list.size();
            int count=listNum+size;

            if (count>=20){
                xlv.setLoadingMoreEnabled(false);


            }


        }



    }
}