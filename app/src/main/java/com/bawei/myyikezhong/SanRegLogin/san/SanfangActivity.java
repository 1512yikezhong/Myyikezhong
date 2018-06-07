package com.bawei.myyikezhong.SanRegLogin.san;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bawei.myyikezhong.R;
import com.bawei.myyikezhong.SanRegLogin.denluzhuce.LoginregActivity;

public class SanfangActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mQq;
    private ImageButton mWeixin;
    /**
     * 其他登陆方式
     */
    private TextView mOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanfang);
        initView();
    }

    private void initView() {
        mQq = (ImageButton) findViewById(R.id.qq);
        mQq.setOnClickListener(this);
        mWeixin = (ImageButton) findViewById(R.id.weixin);
        mWeixin.setOnClickListener(this);
        mOther = (TextView) findViewById(R.id.other);
        mOther.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.qq:
                //使用QQ登录
                break;
            case R.id.weixin:
                //使用微信登录
                break;
            case R.id.other:
                //其他方式登录  跳转到其他页面
              Intent intent = new Intent(SanfangActivity.this, LoginregActivity.class);
                startActivity(intent);
                break;
        }
    }
}
