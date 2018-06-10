package com.bawei.myyikezhong.Qutu.p;

import com.bawei.myyikezhong.Qutu.m.QuMod;
import com.bawei.myyikezhong.Qutu.v.QuView;

import java.util.Map;

/**
 * Created by 王利博 on 2018/6/10.
 */

public class QuPerer implements QuPerIm {
    private QuView quView;
    private QuMod quMod;

    public QuPerer(QuView quView) {
        this.quView = quView;
        quMod=new QuMod(quView);
    }

    @Override
    public void login(Map<String, String> map) {
        quMod.login(map);
    }
}
