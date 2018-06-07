package com.bawei.myyikezhong.SanRegLogin.denluzhuce;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.myyikezhong.MainActivity;
import com.bawei.myyikezhong.R;
import com.bawei.myyikezhong.SanRegLogin.denluzhuce.bean.Studentbean;
import com.bawei.myyikezhong.SanRegLogin.denluzhuce.p.Perer;
import com.bawei.myyikezhong.SanRegLogin.reg.RegActivity;
import com.bawei.myyikezhong.SanRegLogin.san.SanfangActivity;

public class LoginregActivity extends AppCompatActivity implements View.OnClickListener,Iview {

    private ImageView mImg2;
    /**
     * 注册账号
     */
    private TextView mTvZhuce;
    /**
     * 账号
     */
    private EditText mName;
    /**
     * 密码
     */
    private EditText mPass;
    /**
     * 登陆
     */
    private Button mBtnTijiao;
    /**
     * 忘记密码
     */
    private TextView mTvWangjimima;
    /**
     * 游客登陆
     */
    private TextView mTvYouke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginreg);
        initView();
    }


    private void initView() {
        mImg2 = (ImageView) findViewById(R.id.img2);
        mImg2.setOnClickListener(this);
        mTvZhuce = (TextView) findViewById(R.id.tv_zhuce);
        mTvZhuce.setOnClickListener(this);
        mName = (EditText) findViewById(R.id.name);
        mPass = (EditText) findViewById(R.id.pass);
        mBtnTijiao = (Button) findViewById(R.id.btn_tijiao);
        mBtnTijiao.setOnClickListener(this);
        mTvWangjimima = (TextView) findViewById(R.id.tv_wangjimima);
        mTvWangjimima.setOnClickListener(this);
        mTvYouke = (TextView) findViewById(R.id.tv_youke);
        mTvYouke.setOnClickListener(this);
    }

    /**
     * 监听事件
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.img2:
                //点击按钮返回到上一层
                Intent intent = new Intent(LoginregActivity.this, SanfangActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_zhuce:
                //跳转去注册页面
                Intent intent1 = new Intent(LoginregActivity.this, RegActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_tijiao:
                //点击按钮提交信息  账号和密码
                new Perer(this).login();

                break;
            case R.id.tv_wangjimima:
                //跳转忘记密码页面
                break;
            case R.id.tv_youke:
                //点击游客登录跳转到主页面
                Intent intent2 = new Intent(LoginregActivity.this, MainActivity.class);
                startActivity(intent2);
                break;
        }
    }

    /**
     * 账号
     * @return
     */
    @Override
    public String getname() {
        return mName.getText().toString();
    }

    /**
     * 密码
     * @return
     */
    @Override
    public String getpass() {
        return mPass.getText().toString();
    }

    /**
     * 成功的方法
     * @param body
     */
    @Override
    public void getSuccess(Studentbean body) {
        Toast.makeText(this, body.getMsg(), Toast.LENGTH_SHORT).show();
        if(body.getMsg().contains("成功")){
            finish();
            Intent intent = new Intent(LoginregActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
