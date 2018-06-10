package com.bawei.myyikezhong.userjm;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.myyikezhong.R;
import com.bawei.myyikezhong.Tuijian.ui.base.BaseActivity;
import com.bawei.myyikezhong.Tuijian.ui.bean.UserjmBean;
import com.bawei.myyikezhong.Tuijian.ui.component.DaggerHttpComponent;
import com.facebook.drawee.view.SimpleDraweeView;

public class UserActivity extends BaseActivity<UserjmPresenter> implements UserjmContract.View ,View.OnClickListener{


    private ImageView fanhuis;

   private TextView  name,usetname,shijian;
   private SimpleDraweeView touxiang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initData();
    }

    private void initData() {


        int uid = getIntent().getIntExtra("uid", 0);

        mPresenter.getUserjm(String.valueOf(uid),null);
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_user;
    }

    @Override
    public void inject() {

        DaggerHttpComponent.builder()
                .build()
                .inject(this);

    }


    private void initView(){

         fanhuis = findViewById(R.id.fanhuis);
         usetname = findViewById(R.id.username);
         touxiang = findViewById(R.id.imgx);
         name = findViewById(R.id.userninam);
         shijian = findViewById(R.id.shijian);
        fanhuis.setOnClickListener( this);



    }

    @Override
    public void UserSuccess(UserjmBean data) {


        name.setText(data.getData().getMobile());
        usetname.setText(data.getData().getMobile());
        shijian.setText(data.getData().getCreatetime());
        touxiang.setImageURI((Uri) data.getData().getIcon());

    }

    @Override
    public void onClick(android.view.View v) {
        switch (v.getId()){
            case R.id.fanhuis:
                finish();//返回上一层
                break;
        }
    }


}
