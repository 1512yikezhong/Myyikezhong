package com.bawei.myyikezhong.Duanzi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.myyikezhong.R;

/**
 * Created by 王利博 on 2018/6/5.
 */


public class DuanziFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_duanzi, container, false);
        return view;
    }
}