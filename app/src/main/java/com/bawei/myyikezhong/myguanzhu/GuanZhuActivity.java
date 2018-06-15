package com.bawei.myyikezhong.myguanzhu;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bawei.myyikezhong.R;
import com.bawei.myyikezhong.Tuijian.ui.base.BaseActivity;
import com.bawei.myyikezhong.Tuijian.ui.bean.MyGuanzhuBean;
import com.bawei.myyikezhong.Tuijian.ui.component.DaggerHttpComponent;

import java.util.List;

public class GuanZhuActivity extends BaseActivity<MyGuanzhuPresenter> implements MyGuanzhuContract.View{

    private RecyclerView guanzhu;

    private MyGzAdapter myGzAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


         guanzhu = findViewById(R.id.myguanzhu);

         if (mPresenter!=null){
             mPresenter.getMyGuanzhu();
         }

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_guan_zhu;
    }

    @Override
    public void inject() {

        DaggerHttpComponent.builder()
                .build()
                .inject(this);

    }

    @Override
    public void myGunzhu(List<MyGuanzhuBean.DataBean> data) {


        guanzhu.setLayoutManager(new LinearLayoutManager(GuanZhuActivity.this, LinearLayoutManager.VERTICAL,false));
        myGzAdapter = new MyGzAdapter(this, data);

        guanzhu.setAdapter(myGzAdapter);
    }
}
