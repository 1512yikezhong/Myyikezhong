package com.bawei.myyikezhong;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.myyikezhong.Duanzi.DuanziFragment;
import com.bawei.myyikezhong.Qutu.QutuFragment;
import com.bawei.myyikezhong.Shipin.ShipinFragment;
import com.bawei.myyikezhong.Tuijian.TuijianFragment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hjm.bottomtabbar.BottomTabBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private BottomTabBar mBtb;
    private SimpleDraweeView mSdv;
    /**
     * 视频
     */
    private TextView mTv;
    private ImageView mImgbtn;
    private ListView mLv;
    List<Map<String, Object>> list;
    private LinearLayout mLl;
    private DrawerLayout mDl;
    //侧拉框的数据
    int imgarr[] = {R.mipmap.raw_1499933216, R.mipmap.raw_1499947358, R.mipmap.raw_1499946865, R.mipmap.raw_1499947389};
    final String tvarr[] = {"我的关注", "我的收藏", "搜索好友", "消息通知"};
    private SimpleDraweeView mA;

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
        // SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, getData(), R.layout.listview_item, new String[]{"ivPic", "tvText"}, new int[]{R.id.ivPic, R.id.tvtext});
        mLv.setAdapter(simpleAdapter);
        //mLv的点击事件
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, tvarr[i], Toast.LENGTH_SHORT).show();
                mDl.closeDrawer(mLl);
            }
        });
    }

    private void initView() {
        mBtb = (BottomTabBar) findViewById(R.id.btb);
        mSdv = (SimpleDraweeView) findViewById(R.id.sdv);
        mSdv.setOnClickListener(this);
        mTv = (TextView) findViewById(R.id.tv);
        mImgbtn = (ImageView) findViewById(R.id.imgbtn);
        mImgbtn.setOnClickListener(this);
        mLv = (ListView) findViewById(R.id.lv);

        mLl = (LinearLayout) findViewById(R.id.ll);
        mDl = (DrawerLayout) findViewById(R.id.activity_main);
        mA = (SimpleDraweeView) findViewById(R.id.a);
        mA.setOnClickListener(this);
    }

    /**
     * 图片点击
     *
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
                //点击头像调用侧拉框  左侧出现
                mDl.openDrawer(Gravity.LEFT);
                break;
            case R.id.a:
                //点击头像登录

                break;

        }
    }

    /**
     * 侧拉的数据
     *
     * @return
     */

    private List<Map<String, Object>> getData() {

        list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < tvarr.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("ivPic", imgarr[i]);    //显示的图片信息
            map.put("tvText", tvarr[i]);                  //显示的文字信息
            list.add(map);
        }
        return list;
    }
}
