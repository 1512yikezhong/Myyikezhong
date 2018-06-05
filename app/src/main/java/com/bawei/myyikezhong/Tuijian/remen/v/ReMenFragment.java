package com.bawei.myyikezhong.Tuijian.remen.v;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.myyikezhong.R;
import com.bawei.myyikezhong.Tuijian.remen.beans.Imgbean;
import com.bawei.myyikezhong.Tuijian.remen.beans.Videobean;
import com.bawei.myyikezhong.Tuijian.remen.net.GlideImageLoader;
import com.bawei.myyikezhong.Tuijian.remen.p.Per;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class ReMenFragment extends Fragment implements RementView {
    private View view;
    private Banner mBanner;
    //存放图片的集合
    private List<String> list = new ArrayList<>();
    private XRecyclerView mXrv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_remen, container, false);
        initView(view);
        new Per(this).login();
        new Per(this).loginvideo(1+"");
        return view;
    }

    private void initView(View view) {
        mBanner = (Banner) view.findViewById(R.id.banner);
        //设置图片轮播
        mBanner.setImageLoader(new GlideImageLoader());
        mXrv = (XRecyclerView) view.findViewById(R.id.xrv);
    }

    @Override
    public void getSuccess(Imgbean body) {
        // Log.e("aaaa",body.getData().size()+"");
        List<Imgbean.DataBean> data = body.getData();
        for (int i = 0; i < data.size(); i++) {
            list.add(data.get(i).getIcon());
        }
        //设置图片集合
        Log.d("-------", list.size() + "");
        mBanner.setImages(list);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
    }

    /**
     * 获取视频的数据信息
     * 6日 写适配器 上下拉刷线
     * @param body
     */
    @Override
    public void getVideoSuccess(Videobean body) {
        Log.e("aaaaa",body.getMsg());

    }
}
