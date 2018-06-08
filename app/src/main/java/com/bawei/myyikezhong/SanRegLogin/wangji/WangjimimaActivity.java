package com.bawei.myyikezhong.SanRegLogin.wangji;

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
import com.bawei.myyikezhong.SanRegLogin.xiugai.v.XiugaiActivity;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

public class WangjimimaActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mBack;
    /**
     * 已有账号？
     */
    private TextView mTvWangji;
    private ImageView mImg1;
    /**
     * 请输入手机号
     */
    private EditText mEtName;
    /**
     * 请输入密验证码
     */
    private EditText mEtPass;
    /**
     * 下一步
     */
    private Button mBtnNext;
    /**
     * 游客登陆
     */
    private TextView mTvYouke;
    /**
     * 验
     */
    private Button mYan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wangjimima);
        initView();
    }

    private void initView() {
        mBack = (ImageView) findViewById(R.id.back);
        mBack.setOnClickListener(this);
        mTvWangji = (TextView) findViewById(R.id.tv_wangji);
        mTvWangji.setOnClickListener(this);
        mImg1 = (ImageView) findViewById(R.id.img1);
        mEtName = (EditText) findViewById(R.id.et_name);
        mEtPass = (EditText) findViewById(R.id.et_pass);
        mBtnNext = (Button) findViewById(R.id.btn_next);
        mBtnNext.setOnClickListener(this);
        mTvYouke = (TextView) findViewById(R.id.tv_youke);
        mTvYouke.setOnClickListener(this);
        mYan = (Button) findViewById(R.id.yan);
        mYan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                //点击图片按钮返回到上一层
                Intent intent = new Intent(WangjimimaActivity.this, LoginregActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_wangji:
                //返回到登录页面进行登录
                Intent intent1 = new Intent(WangjimimaActivity.this, LoginregActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_next:
               //下一步
                if(mEtPass.getText().toString()!=null&&!"".equals(mEtPass.getText().toString())){
                    submitCode("86",mEtName.getText().toString(),mEtPass.getText().toString());
                }else{
                    Toast.makeText(this,"验证码不能为空",Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.tv_youke:
                //点击游客登录  至今进入main
                Intent intent2 = new Intent(WangjimimaActivity.this, MainActivity.class);
                startActivity(intent2);
                break;
            case R.id.yan:
                //判断手机号是否正确
                //正则验证
                String phonenumber = mEtName.getText().toString();
                String telRegex = "[1][34578]\\d{9}";

                boolean matches = phonenumber.matches(telRegex);
                Log.e("aaaaa",""+matches);
                if(matches){
                sendCode("86",mEtName.getText().toString());
                Toast.makeText(this,"信息已发送 注意查收",Toast.LENGTH_SHORT).show();
            }else{
                    Toast.makeText(this,"手机号码不正确",Toast.LENGTH_SHORT).show();
                }



                break;
        }
    }



    // 请求验证码，其中country表示国家代码，如“86”；phone表示手机号码，如“13800138000”
    public void sendCode(String country, String phone) {
        // 注册一个事件回调，用于处理发送验证码操作的结果
        SMSSDK.registerEventHandler(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    // TODO 处理成功得到验证码的结果
                    // 请注意，此时只是完成了发送验证码的请求，验证码短信还需要几秒钟之后才送达
                } else{
                    // TODO 处理错误的结果
                }

            }
        });
        // 触发操作
        SMSSDK.getVerificationCode(country, phone);
    }

    // 提交验证码，其中的code表示验证码，如“1357”
    public void submitCode(String country, String phone, String code) {
        // 注册一个事件回调，用于处理提交验证码操作的结果
        SMSSDK.registerEventHandler(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    // TODO 处理验证成功的结果
                    Log.e("aaaa","成功");

                    // 跳转重密码页面
                    Intent intent = new Intent(WangjimimaActivity.this, XiugaiActivity.class);
                    intent.putExtra("name",mEtName.getText().toString());
                    startActivity(intent);

                } else{
                    // TODO 处理错误的结果
                    Log.e("aaaa","失败");
                }

            }
        });
        // 触发操作
        SMSSDK.submitVerificationCode(country, phone, code);
    }

    protected void onDestroy() {
        super.onDestroy();
        //用完回调要注销掉，否则可能会出现内存泄露
        SMSSDK.unregisterAllEventHandler();
    };

}
