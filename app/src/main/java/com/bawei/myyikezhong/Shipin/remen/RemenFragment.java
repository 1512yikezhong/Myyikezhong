package com.bawei.myyikezhong.Shipin.remen;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.bawei.myyikezhong.R;
import com.bawei.myyikezhong.Tuijian.ui.base.BaseFragment;
import com.bawei.myyikezhong.Tuijian.ui.bean.HotBean;
import com.bawei.myyikezhong.Tuijian.ui.component.DaggerHttpComponent;
import com.bawei.myyikezhong.Xiangqing.XiangQingActivity;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RemenFragment extends BaseFragment<RemenPresenter> implements  RemenContract.View  {

    private XRecyclerView xlv;

    private List<HotBean.DataBean> list = new ArrayList<>();

    private int page = 1;
    private boolean isRefresh = true;

    private RemenAdapter remenAdapter;


    @Override
    public int getContentLayout() {
        return R.layout.fragment_remenvideos;
    }

    @Override
    public void inject() {

        DaggerHttpComponent.builder()
                .build()
                .inject(this);

    }

    @Override
    public void initView(View view) {
        xlv = view.findViewById(R.id.xrk);
        xlv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        xlv.setItemAnimator(new DefaultItemAnimator());
        remenAdapter = new RemenAdapter(getContext(), list);
        xlv.setAdapter(remenAdapter);
        mPresenter.getHotVideo(page+"");


        //设置刷新和加载和更多

        xlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override   ///
            public void onRefresh() {
                //刷新
                page=1;
                isRefresh=true;
                mPresenter.getHotVideo(page+"");

            }

            @Override
            public void onLoadMore() {
                //加载更多
                page++;
                isRefresh=false;
                mPresenter.getHotVideo(page+"");

            }
        });

        remenAdapter.setlistener(new RemenAdapter.Listener() {
            @Override
            public void onClick(View view, int position) {

                Intent intent=new Intent(getContext(), XiangQingActivity.class);
                intent.putExtra("wid",list.get(position).getWid());
                startActivity(intent);
               // intent.putExtra("wid",data.get(postion).getWid());                startActivity(intent);
               // startActivity(new Intent(getContext(), XiangQingActivity.class));
            }

            @Override
            public void longClick(View view, int position) {

            }
        });


    }

    @Override
    public void hotSuccess(List<HotBean.DataBean> list) {

        //刷新和加载更多

        if (isRefresh){
            remenAdapter.refresh(list);
            //关闭刷新
            xlv.refreshComplete();
        } else {

            remenAdapter.loadMore(list);
            //结束加载更多

            int listNum = remenAdapter.getListNum();
            xlv.refreshComplete();
            int size=list.size();
            int count=listNum+size;

            if (count>=20){
                xlv.setLoadingMoreEnabled(false);

            }



    }
    }
}
