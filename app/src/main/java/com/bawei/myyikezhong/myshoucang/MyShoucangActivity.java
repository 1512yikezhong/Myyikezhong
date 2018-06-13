package com.bawei.myyikezhong.myshoucang;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bawei.myyikezhong.R;
import com.bawei.myyikezhong.Tuijian.ui.base.BaseActivity;
import com.bawei.myyikezhong.Tuijian.ui.bean.MyshoucangBean;
import com.bawei.myyikezhong.Tuijian.ui.component.DaggerHttpComponent;

import java.util.List;

public class MyShoucangActivity extends BaseActivity<MyScPresengter>  implements MyScContract.View, View.OnClickListener{

    private RecyclerView myshoucang;

    private MyShoucAdapter myShoucAdapter;
    private ImageView fanhuisc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myshoucang = findViewById(R.id.myshoucang);
        fanhuisc=  findViewById(R.id.fanhuisc);
        fanhuisc.setOnClickListener(this);

        mPresenter.myShoucang("11068","C55773B10ABD8BFB6739BD5C16D6F803");

    }

    @Override
    public int getContentLayout() {

        return R.layout.activity_my_shoucang;

    }

    @Override
    public void inject() {

        DaggerHttpComponent.builder()
                .build()
                .inject(this);

    }

    @Override
    public void myShoucang(List<MyshoucangBean.DataBean> data) {

        myshoucang.setLayoutManager(new LinearLayoutManager(MyShoucangActivity.this, LinearLayoutManager.VERTICAL,false));
        myShoucAdapter = new MyShoucAdapter(this, data);
        myshoucang.setAdapter(myShoucAdapter);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.fanhuisc:
                finish();
                break;
        }
    }
}
