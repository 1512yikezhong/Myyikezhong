package com.bawei.myyikezhong.myguanzhu;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bawei.myyikezhong.R;
import com.bawei.myyikezhong.Tuijian.ui.base.BaseActivity;
import com.bawei.myyikezhong.Tuijian.ui.bean.MyGuanzhuBean;
import com.bawei.myyikezhong.Tuijian.ui.component.DaggerHttpComponent;

import java.util.List;

public class MyGuanzhuActivity extends BaseActivity<MyGuanzhuPresenter> implements  MyGuanzhuContract.View , View.OnClickListener {

    private RecyclerView myguanzhu;
    private ImageView fanhuis;



//    private List<MyGuanzhuBean.DataBean> list = new ArrayList<>();

    private MyGzAdapter myGzAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myguanzhu = findViewById(R.id.myguanzhu);

        fanhuis = findViewById(R.id.fanhuixs);
        fanhuis.setOnClickListener( this);
        mPresenter.getMyGuanzhu();



    }

    @Override
    public int getContentLayout() {

        return R.layout.activity_my_guanzhu;
    }

    @Override
    public void inject() {

        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }



    @Override
    public void onClick(android.view.View v) {
        switch (v.getId()){
            case R.id.fanhuis:
                finish();//返回上一层
                break;
        }
    }

    @Override
    public void myGunzhu(List<MyGuanzhuBean.DataBean> data) {

        myguanzhu.setLayoutManager(new LinearLayoutManager(MyGuanzhuActivity.this, LinearLayoutManager.VERTICAL,false));

        myGzAdapter = new MyGzAdapter(this, data);

        myguanzhu.setAdapter(myGzAdapter);


    }


}
