package com.bawei.myyikezhong;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bawei.myyikezhong.Duanzi.DuanziFragment;
import com.bawei.myyikezhong.Qutu.QutuFragment;
import com.bawei.myyikezhong.Shipin.ShipinFragment;
import com.bawei.myyikezhong.Tuijian.TuijianFragment;
import com.hjm.bottomtabbar.BottomTabBar;

public class MainActivity extends AppCompatActivity {
    private BottomTabBar mBtb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtb = (BottomTabBar) findViewById(R.id.btb);

        mBtb.init(getSupportFragmentManager())
                .setImgSize(50, 50)
                .setFontSize(8)
                .setTabPadding(4, 6, 10)
                .setChangeColor(Color.RED, Color.DKGRAY)
                .addTabItem("推荐", R.mipmap.raw_1500085367,R.mipmap.raw_1500083878 , TuijianFragment.class)
                .addTabItem("段子",R.mipmap.raw_1500085899, R.mipmap.raw_1500085327  , DuanziFragment.class)
                .addTabItem("视频", R.mipmap.raw_1500086067,R.mipmap.raw_1500083686 , ShipinFragment.class)
                .addTabItem("趣图", R.mipmap.raw_1500085367,R.mipmap.raw_1500083878 , QutuFragment.class)
                .isShowDivider(true);
    }
}
