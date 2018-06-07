package com.bawei.myyikezhong.SanRegLogin.reg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.myyikezhong.MainActivity;
import com.bawei.myyikezhong.R;
import com.bawei.myyikezhong.SanRegLogin.bean.Userbean;
import com.bawei.myyikezhong.SanRegLogin.denluzhuce.LoginregActivity;
import com.bawei.myyikezhong.SanRegLogin.reg.p.Pere;


public class RegActivity extends AppCompatActivity implements View.OnClickListener, LoginView {

    /**
     * 请输入手机号
     */
    private EditText mEtName;
    /**
     * 请输入密码
     */
    private EditText mEtPass;
    /**
     * 注册
     */
    private Button mBtnZhuce;
    private ImageView mImg2;
    /**
     * 已有账号？
     */
    private TextView mTvWangji;
    /**
     * 游客登陆
     */
    private TextView mTvYouke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        initView();
    }

    private void initView() {
        mEtName = (EditText) findViewById(R.id.et_name);
        mEtPass = (EditText) findViewById(R.id.et_pass);
        mBtnZhuce = (Button) findViewById(R.id.btn_zhuce);
        mBtnZhuce.setOnClickListener(this);
        mImg2 = (ImageView) findViewById(R.id.img2);
        mImg2.setOnClickListener(this);
        mTvWangji = (TextView) findViewById(R.id.tv_wangji);
        mTvWangji.setOnClickListener(this);
        mTvYouke = (TextView) findViewById(R.id.tv_youke);
        mTvYouke.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_zhuce:
                new Pere(this).login();
                break;
            case R.id.img2:
                //点击图片按钮跳转会登录页面
                Intent intent2 = new Intent(RegActivity.this, LoginregActivity.class);
                startActivity(intent2);

                break;

            case R.id.tv_wangji:
                //点击已有按钮直接跳转 登录页面
                Intent intent1 = new Intent(RegActivity.this, LoginregActivity.class);
                startActivity(intent1);
                break;
            case R.id.tv_youke:
                //点击游客登录跳转到主页面
                Intent intent = new Intent(RegActivity.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    /**
     * 返回应户名
     *
     * @return
     */
    @Override
    public String getname() {
        return mEtName.getText().toString();
    }

    /**
     * 返回用户密码
     *
     * @return
     */
    @Override
    public String getpass() {
        return mEtPass.getText().toString();
    }

    /**
     * 获取成功的方法
     *
     * @param body
     */
    @Override
    public void getSuccess(Userbean body) {
        //吐司提示注册信息
        Toast.makeText(this, body.getMsg(), Toast.LENGTH_SHORT).show();
        //如果注册成功 结束当前页面
        if (body.getMsg().contains("成功")) {
            finish();
        }

    }
}
