package com.bawei.myyikezhong.Shipin.fujin;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.bawei.myyikezhong.R;
import com.bawei.myyikezhong.Tuijian.ui.base.BaseFragment;
import com.bawei.myyikezhong.Tuijian.ui.bean.FujinBean;
import com.bawei.myyikezhong.Tuijian.ui.component.DaggerHttpComponent;
import com.bawei.myyikezhong.Xiangqing.XiangQingActivity;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FujinFragment extends BaseFragment<FujinPresenter> implements FujinContract.View {


    private XRecyclerView xlv;

    private List<FujinBean.DataBean> list = new ArrayList<>();

    private int page = 1;
    private boolean isRefresh = true;

    private FujinAdapter fujinAdapter;

    @Override
    public int getContentLayout() {
        return R.layout.fragment_fujin;
    }

    @Override
    public void inject() {

        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void initView(View view) {

        xlv = view.findViewById(R.id.xrf);

        xlv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        xlv.setItemAnimator(new DefaultItemAnimator());
        fujinAdapter = new FujinAdapter(getContext(), list);
        xlv.setAdapter(fujinAdapter);
        mPresenter.getfujin(page+"");
        //设置刷新和加载和更多

        xlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override   ///
            public void onRefresh() {
                //刷新
                page=1;
                isRefresh=true;
                mPresenter.getfujin(page+"");

            }

            @Override
            public void onLoadMore() {
                //加载更多
                page++;
                isRefresh=false;
                mPresenter.getfujin(page+"");

            }
        });


        fujinAdapter.setlistener(new FujinAdapter.Listener() {
            @Override
            public void onClick(View view, int position) {

                Intent intent=new Intent(getContext(), XiangQingActivity.class);
                intent.putExtra("wid",list.get(position).getWid());
                startActivity(intent);
            }

            @Override
            public void longClick(View view, int position) {

            }
        });
    }


    @Override
    public void fjSuccess(List<FujinBean.DataBean> list) {

        //刷新和加载更多

        if (isRefresh){
            fujinAdapter.refresh(list);
            //关闭刷新
            xlv.refreshComplete();
        } else {

            fujinAdapter.loadMore(list);
            //结束加载更多

            int listNum = fujinAdapter.getListNum();
            xlv.refreshComplete();
            int size=list.size();
            int count=listNum+size;

            if (count>=20){
                xlv.setLoadingMoreEnabled(false);

            }



        }
    }
}
