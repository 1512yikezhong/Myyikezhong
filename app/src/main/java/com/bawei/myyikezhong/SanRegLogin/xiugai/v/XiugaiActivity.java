package com.bawei.myyikezhong.SanRegLogin.xiugai.v;

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
import com.bawei.myyikezhong.SanRegLogin.denluzhuce.LoginregActivity;
import com.bawei.myyikezhong.SanRegLogin.xiugai.bean.Xiugaibean;
import com.bawei.myyikezhong.SanRegLogin.xiugai.p.XiugaiPer;

import java.util.HashMap;
import java.util.Map;

public class XiugaiActivity extends AppCompatActivity implements View.OnClickListener,XiugaiView {

    private ImageView mBack;
    /**
     * 已有账号？
     */
    private TextView mTvWangji;
    private ImageView mImg1;
    /**
     * 输入大小写和数字，密码不能超过8位
     */
    private EditText mEtPass;
    /**
     * 请再次输入密码
     */
    private EditText mEtPass1;
    /**
     * 完成
     */
    private Button mOver;
    /**
     * 游客登陆
     */
    private TextView mTvYouke;
   private   String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiugai);
          name = getIntent().getStringExtra("name");
        initView();
    }

    private void initView() {
        mBack = (ImageView) findViewById(R.id.back);
        mBack.setOnClickListener(this);
        mTvWangji = (TextView) findViewById(R.id.tv_wangji);
        mTvWangji.setOnClickListener(this);
        mImg1 = (ImageView) findViewById(R.id.img1);
        mEtPass = (EditText) findViewById(R.id.xiugaipass);
        mEtPass1 = (EditText) findViewById(R.id.xiugaipass1);
        mOver = (Button) findViewById(R.id.over);
        mOver.setOnClickListener(this);
        mTvYouke = (TextView) findViewById(R.id.tv_youke);
        mTvYouke.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                //返回到登录页面
               tiaozhuan();
                break;
            case R.id.tv_wangji:
                //返回到登录页面
                tiaozhuan();
                break;
            case R.id.over:
                if(mEtPass.getText().toString().equals(mEtPass1.getText().toString())&&mEtPass.getText().toString()!=null&&mEtPass1.getText().toString()!=null&&!"".equals(mEtPass.getText().toString())&&!"".equals(mEtPass1.getText().toString())){
                    Log.e("aaaaaaa",mEtPass.getText().toString());
                    //明天来掉接口 修改密码
                    Map<String,String> map=new HashMap<>();
                    map.put("mobile",name);
                    map.put("newPass",mEtPass.getText().toString());
                    //进行网络请求
                    new XiugaiPer(this).login(map);


                }else{
                    Log.e("aaaaaaa","aaaaaaaaaaaa");
                }


                break;
            case R.id.tv_youke:
                //游客登录直接到主页面
                Intent intent1 = new Intent(XiugaiActivity.this, MainActivity.class);
                startActivity(intent1);
                break;
        }
    }

    private void tiaozhuan() {
        Intent intent = new Intent(XiugaiActivity.this, LoginregActivity.class);
        startActivity(intent);
    }

    /**
     * 成功的方法
     * 提示用户修改密码情况
     * @param body
     */

    @Override
    public void getSuccess(Xiugaibean body) {
        Toast.makeText(this,body.getMsg(),Toast.LENGTH_SHORT).show();
        //跳转登录页面
        Intent intent = new Intent(XiugaiActivity.this, LoginregActivity.class);
        startActivity(intent);
    }
}
