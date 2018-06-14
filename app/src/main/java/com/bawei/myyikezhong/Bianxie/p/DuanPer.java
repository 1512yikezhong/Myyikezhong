package com.bawei.myyikezhong.Bianxie.p;

import com.bawei.myyikezhong.Bianxie.m.DuanMod;
import com.bawei.myyikezhong.Bianxie.v.DuanView;

import java.util.Map;

/**
 * Created by 王利博 on 2018/6/13.
 */

public class DuanPer implements DuanPerIm {
    private DuanView duanView;
    private DuanMod duanMod;

    public DuanPer(DuanView duanView) {
        this.duanView = duanView;
        duanMod=new DuanMod(duanView);
    }

    @Override
    public void login(Map<String, String> map) {
        duanMod.login(map);
    }
}
