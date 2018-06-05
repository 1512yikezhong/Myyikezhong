package com.bawei.myyikezhong;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.myyikezhong.Duanzi.DuanziFragment;
import com.bawei.myyikezhong.Qutu.QutuFragment;
import com.bawei.myyikezhong.Shipin.ShipinFragment;
import com.bawei.myyikezhong.Tuijian.TuijianFragment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hjm.bottomtabbar.BottomTabBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private BottomTabBar mBtb;
    private SimpleDraweeView mSdv;
    /**
     * 视频
     */
    private TextView mTv;
    private ImageView mImgbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();



        mBtb.init(getSupportFragmentManager())
                .setImgSize(50, 50)
                .setFontSize(8)
                .setTabPadding(4, 6, 10)
                .setChangeColor(Color.RED, Color.DKGRAY)
                .addTabItem("推荐", R.mipmap.raw_1500085367, R.mipmap.raw_1500083878, TuijianFragment.class)
                .addTabItem("段子", R.mipmap.raw_1500085899, R.mipmap.raw_1500085327, DuanziFragment.class)
                .addTabItem("视频", R.mipmap.raw_1500086067, R.mipmap.raw_1500083686, ShipinFragment.class)
                .addTabItem("趣图", R.mipmap.raw_1500085367, R.mipmap.raw_1500083878, QutuFragment.class)
                .isShowDivider(true);
    }

    private void initView() {
        mBtb = (BottomTabBar) findViewById(R.id.btb);
        mSdv = (SimpleDraweeView) findViewById(R.id.sdv);
        mSdv.setOnClickListener(this);
        mTv = (TextView) findViewById(R.id.tv);
        mImgbtn = (ImageView) findViewById(R.id.imgbtn);
        mImgbtn.setOnClickListener(this);
    }

    /**
     * 图片点击
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.imgbtn:
                break;
            case R.id.sdv:
                break;
        }
    }
}
