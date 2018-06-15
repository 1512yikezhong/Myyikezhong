package com.bawei.myyikezhong.Tuijian.ui;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bawei.myyikezhong.R;
import com.bawei.myyikezhong.Tuijian.ui.adapter.VideoAdapter;
import com.bawei.myyikezhong.Tuijian.ui.base.BaseFragment;
import com.bawei.myyikezhong.Tuijian.ui.bean.VideoBean;
import com.bawei.myyikezhong.Tuijian.ui.bean.YesBean;
import com.bawei.myyikezhong.Tuijian.ui.component.DaggerHttpComponent;
import com.bawei.myyikezhong.Tuijian.ui.guanzhu.contract.GuanzhuContract;
import com.bawei.myyikezhong.Tuijian.ui.guanzhu.presenter.Guanzhuprensenter;

import java.util.ArrayList;
import java.util.List;

public class GuanZhuFragment extends BaseFragment<Guanzhuprensenter> implements GuanzhuContract.View {

    private List<VideoBean.DataBean> data=new ArrayList<>();

    private VideoAdapter videoAdapter;

    private VideoBean videoBean;


   // private boolean istrue;


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
      //  ImageView img= view.findViewById(R.id.dianzan);

        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.addItemDecoration(new DividerItemDecoration(getContext(),RecyclerView.VERTICAL));

        videoAdapter = new VideoAdapter(getContext(), data);
        rv.setAdapter(videoAdapter);
        if (mPresenter!=null){
            mPresenter.getVideo();

        }



        videoAdapter.setlistener(new VideoAdapter.Listener() {
            @Override
            public void onClick(View view, int position) {



                if (mPresenter!=null){

                    mPresenter.dianzan("11068","C55773B10ABD8BFB6739BD5C16D6F803","228");

                }
            }

            @Override
            public void longClick(View view, int position) {

            }
        });


//        img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (mPresenter!=null){
//                  mPresenter.dianzan("11068","C55773B10ABD8BFB6739BD5C16D6F803","228");
//
//                }
//            }
//        });




    }
    @Override
    public void videoSuccess(List<VideoBean.DataBean> data) {


        if (videoAdapter!=null){

            videoAdapter.setData(data);

        }
    }

    @Override
    public void dianzan(YesBean data) {

        Toast.makeText(getActivity(),data.getMsg(),Toast.LENGTH_LONG).show();


    }


}
