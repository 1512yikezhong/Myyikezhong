package com.bawei.myyikezhong.SanRegLogin.san;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.myyikezhong.R;
import com.bawei.myyikezhong.SanRegLogin.denluzhuce.LoginregActivity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;


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
                    getQQ();
                break;
            case R.id.weixin:
                //使用微信登录
                getWeiXin();
                break;
            case R.id.other:
                //其他方式登录  跳转到其他页面
              Intent intent = new Intent(SanfangActivity.this, LoginregActivity.class);
                startActivity(intent);
                break;
        }
    }
    /*
    * 第三方登录QQ
    * */
    public void getQQ(){

        Platform plat = ShareSDK.getPlatform(QQ.NAME);
        plat.removeAccount(true); //移除授权状态和本地缓存，下次授权会重新授权
        plat.SSOSetting(false); //SSO授权，传false默认是客户端授权，没有客户端授权或者不支持客户端授权会跳web授权
        plat.setPlatformActionListener(new PlatformActionListener() {//授权回调监听，监听oncomplete，onerror，oncancel三种状态
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                Iterator iterator = hashMap.entrySet().iterator();
                while (iterator.hasNext()){
                    Map.Entry next = (Map.Entry) iterator.next();
                    Object key = next.getKey();
                    Object value = next.getValue();
                    Log.d("哈哈", "onComplete: "+key+"  "+value);

                }
            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {
                Log.d("哈哈", "onError: "+platform.getName()+" "+platform.getDb()+"  "+"  "+platform.getId()+"  "+platform.getPlatformActionListener()+" "+platform.getVersion());
            }

            @Override
            public void onCancel(Platform platform, int i) {
                Log.d("哈哈", "onCancel: "+platform.getName());
            }
        });
        if (plat.isClientValid()) {
            //todo 判断是否存在授权凭条的客户端，true是有客户端，false是无
        }
        if (plat.isAuthValid()) {
            //todo 判断是否已经存在授权状态，可以根据自己的登录逻辑设置
            Toast.makeText(this, "已经授权过了", Toast.LENGTH_SHORT).show();
            return;
        }
        //plat.authorize();    //要功能，不要数据
        plat.showUser(null);    //要数据不要功能，主要体现在不会重复出现授权界面
    }
    /*
    * 第三方微信登录
    * */
    public void getWeiXin(){

        Platform plat = ShareSDK.getPlatform(Wechat.NAME);
        plat.removeAccount(true); //移除授权状态和本地缓存，下次授权会重新授权
        plat.SSOSetting(false); //SSO授权，传false默认是客户端授权，没有客户端授权或者不支持客户端授权会跳web授权
        plat.setPlatformActionListener(new PlatformActionListener() {//授权回调监听，监听oncomplete，onerror，oncancel三种状态
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                Iterator iterator = hashMap.entrySet().iterator();
                while (iterator.hasNext()){
                    Map.Entry next = (Map.Entry) iterator.next();
                    Object key = next.getKey();
                    Object value = next.getValue();
                    Log.d("哈哈", "onComplete: "+key+"  "+value);

                }
            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {
                Log.d("哈哈", "onError: "+platform.getName()+" "+platform.getDb()+"  "+"  "+platform.getId()+"  "+platform.getPlatformActionListener()+" "+platform.getVersion());
            }

            @Override
            public void onCancel(Platform platform, int i) {
                Log.d("哈哈", "onCancel: "+platform.getName());
            }
        });
        if (plat.isClientValid()) {
            //todo 判断是否存在授权凭条的客户端，true是有客户端，false是无
        }
        if (plat.isAuthValid()) {
            //todo 判断是否已经存在授权状态，可以根据自己的登录逻辑设置
            Toast.makeText(this, "已经授权过了", Toast.LENGTH_SHORT).show();
            return;
        }
        //plat.authorize();    //要功能，不要数据
        plat.showUser(null);    //要数据不要功能，主要体现在不会重复出现授权界面
    }


}
