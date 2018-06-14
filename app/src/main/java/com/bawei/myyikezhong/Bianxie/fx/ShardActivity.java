package com.bawei.myyikezhong.Bianxie.fx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bawei.myyikezhong.MainActivity;
import com.bawei.myyikezhong.R;

public class ShardActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mFriend;
    private ImageView mKongjian;
    private ImageView mWei;
    private ImageView mQ;
    /**
     * 前去看看！
     */
    private Button mLook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shard);
        initView();
    }

    private void initView() {
        mFriend = (ImageView) findViewById(R.id.friend);
        mFriend.setOnClickListener(this);
        mKongjian = (ImageView) findViewById(R.id.kongjian);
        mKongjian.setOnClickListener(this);
        mWei = (ImageView) findViewById(R.id.wei);
        mWei.setOnClickListener(this);
        mQ = (ImageView) findViewById(R.id.q);
        mQ.setOnClickListener(this);
        mLook = (Button) findViewById(R.id.look);
        mLook.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.friend:
                break;
            case R.id.kongjian:
                break;
            case R.id.wei:
                break;
            case R.id.q:
                break;
            case R.id.look:
                //回到主activity
                Intent intent = new Intent(ShardActivity.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
