package com.bawei.myyikezhong.Xiangqing;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.myyikezhong.R;
import com.bawei.myyikezhong.Tuijian.ui.base.BaseActivity;
import com.bawei.myyikezhong.Tuijian.ui.bean.XqBean;
import com.bawei.myyikezhong.Tuijian.ui.component.DaggerHttpComponent;
import com.bawei.myyikezhong.shard.Shared;
import com.facebook.drawee.view.SimpleDraweeView;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerSimple;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class XiangQingActivity extends BaseActivity<Xiangqingpresenter> implements XqContract.View,XqContract, View.OnClickListener {


    private JCVideoPlayerSimple shiping;
    private  SimpleDraweeView tou;
   private  TextView  nishuo;
   private TextView niha;
   private ImageView fanhui;
    private ImageView btnimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initData();
    }

    private void initData() {

        int wid = getIntent().getIntExtra("wid", 0);

        mPresenter.getXq(String.valueOf(wid));

    }


    @Override
    public int getContentLayout() {
        return R.layout.activity_xiang_qing;
    }

    @Override
    public void inject() {

        DaggerHttpComponent.builder()
                .build().inject(this);
    }



    private void initView(){
        shiping = findViewById(R.id.xqvideo);

        tou = findViewById(R.id.imgt);

          nishuo = findViewById(R.id.texts);

       niha=  findViewById(R.id.texts);
         fanhui = findViewById(R.id.fanhui);
        btnimg=findViewById(R.id.btn_img);
         fanhui.setOnClickListener( this);

    }

    @Override
    public void XqSuccess(final XqBean data) {


        final String videoUrl = data.getData().getVideoUrl();
        //视频判空
        if(videoUrl==null){
            return;
        }

        shiping.setUp(videoUrl,JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL);
        tou.setImageURI(data.getData().getUser().getIcon());
        nishuo.setText(data.getData().getUser().getNickname());
        niha.setText(data.getData().getCreateTime());
        btnimg.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Log.e("qazxsw","点击了飞享按钮111");
                new Shared(XiangQingActivity.this,videoUrl);
            }
        });
    }


    @Override
    public void onClick(android.view.View v) {
        switch (v.getId()){
            case R.id.fanhui:
                finish();//返回上一层
                break;
        }
    }
}
