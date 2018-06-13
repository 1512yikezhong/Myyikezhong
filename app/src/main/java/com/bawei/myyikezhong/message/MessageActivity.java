package com.bawei.myyikezhong.message;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bawei.myyikezhong.R;
import com.bawei.myyikezhong.message.message.MessageFragment;
import com.bawei.myyikezhong.message.privatemessage.PrivateFragment;

import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends AppCompatActivity implements View.OnClickListener{

    private TabLayout tab;
    private ViewPager viewPager;
    private List<String> list;

    private ImageView fanhuim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);


        inittabs();
        initView();

    }

    private void inittabs() {

        list = new ArrayList<>();
        list.add("消息");
        list.add("私信");
    }

    private void initView() {

        tab= findViewById(R.id.tablayoutm);
        viewPager= findViewById(R.id.viewpagem);
         fanhuim = findViewById(R.id.fanhuixm);
         fanhuim.setOnClickListener(this);

        tab.setupWithViewPager(viewPager);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position==0){

                    MessageFragment messageFragment = new MessageFragment();
                    return  messageFragment;


                }else {

                    PrivateFragment privateFragment = new PrivateFragment();
                    return  privateFragment;
                }

            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.fanhuixm:
                finish();
                break;
        }
    }
}
