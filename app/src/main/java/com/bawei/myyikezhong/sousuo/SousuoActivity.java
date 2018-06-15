
package com.bawei.myyikezhong.sousuo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bawei.myyikezhong.R;
import com.bawei.myyikezhong.Tuijian.ui.base.BaseActivity;
import com.bawei.myyikezhong.Tuijian.ui.bean.SousuoBean;
import com.bawei.myyikezhong.Tuijian.ui.bean.SuijiBean;
import com.bawei.myyikezhong.Tuijian.ui.component.DaggerHttpComponent;

import java.util.List;

public class SousuoActivity extends BaseActivity<SousuoPresenter> implements SousuoContract.View {


    private RecyclerView sousuo;

    private SousuoAdapter sousuoAdapter;

    private EditText shuru;

    private   Button btm;
    private  SuijiAdapter suijiAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sousuo = findViewById(R.id.sousuo);
         shuru = findViewById(R.id.souuser);
         btm = findViewById(R.id.soussuo);

         if (mPresenter!=null){
             mPresenter.suiji();
         }

        btm.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 String sousuo = shuru.getText().toString().trim();

                 mPresenter.mysousuo(sousuo,"1");

               //  notifyAll();

             }
         });


    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_sousuo;
    }

    @Override
    public void inject() {

        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void sousuo(List<SousuoBean.DataBean> data) {

if (data!=null){
    sousuo.setLayoutManager(new LinearLayoutManager(SousuoActivity.this, LinearLayoutManager.VERTICAL,false));

    sousuoAdapter= new SousuoAdapter(this, data);
    sousuo.setAdapter(sousuoAdapter);
}


    }

    @Override
    public void suiji(List<SuijiBean.DataBean> data) {

        if (data!=null){
            sousuo.setLayoutManager(new LinearLayoutManager(SousuoActivity.this, LinearLayoutManager.VERTICAL,false));

            suijiAdapter= new SuijiAdapter(this, data);
            sousuo.setAdapter(suijiAdapter);
        }




    }
}
