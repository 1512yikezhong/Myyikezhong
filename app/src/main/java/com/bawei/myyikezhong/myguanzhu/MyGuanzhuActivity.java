package com.bawei.myyikezhong.myguanzhu;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.myyikezhong.R;
import com.bawei.myyikezhong.Tuijian.ui.base.BaseActivity;
import com.bawei.myyikezhong.Tuijian.ui.bean.MyGuanzhuBean;
import com.bawei.myyikezhong.Tuijian.ui.component.DaggerHttpComponent;

import java.util.List;

import rx.observers.TestObserver;

public class MyGuanzhuActivity extends BaseActivity<MyGuanzhuPresenter> implements  View.OnClickListener,MyGuanzhuContract.View  {

    private RecyclerView myguanzhu;
    private ImageView fanhuis;



//    private List<MyGuanzhuBean.DataBean> list = new ArrayList<>();

    private MyGzAdapter myGzAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            Log.e("asasasas","aaaaaaaaa");
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
    public void myGunzhu(List<MyGuanzhuBean.DataBean> data) {

      if(data!=null){
          myguanzhu.setLayoutManager(new LinearLayoutManager(MyGuanzhuActivity.this, LinearLayoutManager.VERTICAL,false));

          myGzAdapter = new MyGzAdapter(this, data);

          myguanzhu.setAdapter(myGzAdapter);

      }else{
          Toast.makeText(this,"空",Toast.LENGTH_SHORT).show();
      }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.fanhuis:
                finish();
                break;
        }
    }
}
