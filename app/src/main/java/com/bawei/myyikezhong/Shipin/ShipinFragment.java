package com.bawei.myyikezhong.Shipin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.myyikezhong.R;
import com.bawei.myyikezhong.Shipin.fujin.FujinFragment;
import com.bawei.myyikezhong.Shipin.remen.RemenFragment;
import com.bawei.myyikezhong.Tuijian.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王利博 on 2018/6/5.
 */

public class ShipinFragment extends Fragment {
    private TabLayout tab;
    private ViewPager viewPager;

    List<Fragment> list=new ArrayList<>();
    List<String> listStr = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_shipin, container, false);
        tab = view.findViewById(R.id.tablayout);
        viewPager = view.findViewById(R.id.viewpage);
        initView();

        return view;


    }

    private void initView() {
        //初始化
        initDate();

        MyAdapter my = new MyAdapter(getChildFragmentManager(), list, listStr);
        viewPager.setAdapter(my);

        //设置TabLayout的模式
        tab.setTabMode(TabLayout.MODE_FIXED);
        //让TabLayout和ViewPager关联
        tab.setupWithViewPager(viewPager);

    }

    private void initDate() {

       RemenFragment reMenFragment = new RemenFragment();
        FujinFragment fujinFragment = new FujinFragment();
        list.add(reMenFragment);
        list.add(fujinFragment);

        String name1 = "热门";
        String name2 = "附近";
        listStr.add(name1);
        listStr.add(name2);

    }
}