package com.bawei.myyikezhong.chuangzuo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.myyikezhong.R;

import java.nio.channels.MembershipKey;

public class MakeActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mBtnshipin;
    private ImageView mBtnduanzi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make);
        initView();
    }

    private void initView() {
        mBtnshipin = (ImageView) findViewById(R.id.btnshipin);
        mBtnshipin.setOnClickListener(this);
        mBtnduanzi = (ImageView) findViewById(R.id.btnduanzi);
        mBtnduanzi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btnshipin:
                //点击视频图片调用相机功能
                Intent intent = new Intent(); //调用照相机
                intent.setAction("android.media.action.STILL_IMAGE_CAMERA");
                startActivity(intent);
                break;
            case R.id.btnduanzi:
                //吐司提示

                Toast.makeText(MakeActivity.this,"编写段子",Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
